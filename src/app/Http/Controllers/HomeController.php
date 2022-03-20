<?php

namespace App\Http\Controllers;

use App\Models\EasyGoBandProviders;
use App\Models\EasyGoBandSessions;
use Carbon\Carbon;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Validator;

class HomeController extends Controller
{
    /**
     * @return view
     */
    public function index()
    {
        return view('home', [
            'providers' => EasyGoBandProviders::with(['session_providers'])->get()
        ]);
    }

    public function read_provider()
    {
        return response()->json(
            EasyGoBandProviders::with(['session_providers'])->get()
        );
    }

    public function delete_provider()
    {
        $validator = Validator::make(request()->all(), [
            'idProvider' => 'required',
        ]);

        if ($validator->fails())
            return response()->json($validator->errors(), 400);

        return response()->json(
            EasyGoBandProviders::where(['id' => request()->only('idProvider')])->delete()
        );
    }

    public function create_update_provider()
    {
        $provider = request()->all();
        $validator = Validator::make($provider, [
            'name'              => $provider->name,
        ]);

        if ($validator->fails())
            return response()->json($validator->errors(), 400);

        DB::beginTransaction();

        $data_provider = EasyGoBandProviders::firstOrCreate(
            [
                'access_group_name' => $provider->access_group_name,
                'access_group_id'   => $provider->access_group_id,
                'total_uses'        => $provider->total_uses,
                'event_id'          => $provider->event_id,
                'structure_decode'  => $provider->structure_decode,
                'name'              => $provider->name,
                'modified'          => Carbon::now()->toDateTimeString(),
                'basic_product_id'  => $provider->basic_product_id,
            ],
            [
                'id' => $provider->id
            ]
        );

        if( !isset($data_provider->id) )
        {
            DB::rollBack();
            return response()->json('Error al crear o actualizar el proveedor', 412);
        }

        if ( isset($data_provider->id) && isset($provider->sessions) )
        {
            foreach( $provider->sessions as $session)
            {
                if( !isset($session->name) && empty($session->name) )
                    continue;

                EasyGoBandSessions::updateOrInsert(
                    [
                        'name'          => $session->name
                    ],
                    [
                        'id_provider'   => $data_provider->id,
                        'id'     => $session->id
                    ]
                );
            }
        }

        DB::commit();
        return response()->json(true);
    }
}
