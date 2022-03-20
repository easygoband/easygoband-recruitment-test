<?php

namespace App\Console\Commands;

use App\Models\EasyGoBandProviders;
use App\Models\EasyGoBandSessions;
use Carbon\Carbon;
use Illuminate\Console\Command;
use Illuminate\Support\Facades\Log;

class CheckProvidersEasyGoBand extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'easygoband:providers';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = 'Update new providers from API geasygobrad';

    private $url    = "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1";
    private $token  = "Authorization: Basic cJmAc71jah17sgqi1jqaksvaksda=";

    /**
     * Execute the console command.
     *
     * @return int
     */
    public function handle()
    {
        $request = $this->request();

        if( $request->error == 1 )
        {
            Log::info('CheckProvidersEasyGoBand');
            Log::info(print_r($request->response, true));
            return false;
        }

        foreach( $request->response as $provider )
        {
            $data_provider = EasyGoBandProviders::firstOrCreate(
                [
                    'access_group_name' => $provider['access_group_name'],
                    'access_group_id' => $provider['access_group_id'],
                    'total_uses' => $provider['total_uses'],
                    'event_id' => $provider['event_id'],
                    'structure_decode' => $provider['structure_decode'],
                    'name' => $provider['name'],
                    'modified' => Carbon::createFromTimestamp(strtotime($provider['modified']))->toDateTimeString(),
                    'id_remote' => $provider['id'],
                    'basic_product_id' => $provider['basic_product_id'],
                ],
                [
                    'id_remote' => $provider['id']
                ]
            );

            if ( isset($data_provider->id) && isset($provider['sessions']) )
            {
                foreach( $provider['sessions'] as $session)
                {
                    EasyGoBandSessions::updateOrInsert(
                        [
                            'id_remote'     => $session['id'],
                            'id_provider'   => $data_provider->id,
                            'name'          => $session['name']
                        ],
                        [
                            'id_provider'   => $data_provider->id,
                            'id_remote'     => $session['id']
                        ]
                    );
                }
            }
        }

        return true;
    }

    private function request()
    {
        $curl = curl_init();

        curl_setopt_array($curl, [
            CURLOPT_URL => $this->url,
            CURLOPT_HTTPHEADER => [
                $this->token
            ],
            CURLOPT_RETURNTRANSFER  => true,
            CURLOPT_ENCODING        => "",
            CURLOPT_MAXREDIRS       => 10,
            CURLOPT_TIMEOUT         => 900,
            CURLOPT_SSL_VERIFYPEER  => false,
            CURLOPT_HTTP_VERSION    => CURL_HTTP_VERSION_1_1,
            CURLOPT_CUSTOMREQUEST   => "GET"
        ]);

        $response   = curl_exec($curl);
        $err        = curl_error($curl);

        curl_close($curl);

        $res        = new \stdClass();
        $res->error = 0;
        $res->http_response_code = curl_getinfo($curl, CURLINFO_HTTP_CODE);

        if (!empty($err) ||  $res->http_response_code != 200)
        {
            $res->error         = 1;
            $res->error_text    = $err;
        }

        $res->response = json_decode($response, true);

        return $res;
    }
}
