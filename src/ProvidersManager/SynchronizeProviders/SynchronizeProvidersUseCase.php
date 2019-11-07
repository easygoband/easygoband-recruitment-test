<?php

namespace App\ProvidersManager\SynchronizeProviders;

use App\Entity\Provider;
use App\Entity\Session;
use DateTime;
use Doctrine\ORM\EntityManager;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpClient\HttpClient;

class SynchronizeProvidersUseCase
{
    /* @var EntityManager $em */
    private $em = null;

    public function __construct(EntityManagerInterface $em)
    {
        $this->em = $em;
    }

    public function execute()
    {
        $apiProviders = $this->getDataFromApi();

        foreach ($apiProviders as $apiProvider) {
            $providerSessions = [];
            foreach ($apiProvider['sessions'] as $apiSession) {
                $session = $this->em->getRepository(Session::class)->find($apiSession['id']);
                if (is_null($session)) {
                    $session = new Session();
                    $session->create($apiSession['id'], $apiSession['name']);

                    $this->em->persist($session);
                    $this->em->flush();
                }

                $providerSessions[] = $session;
            }

            /* @var Provider $provider */
            $provider = $this->em->getRepository(Provider::class)->find($apiProvider['id']);
            if (is_null($provider)) {
                $provider = new Provider();
                $provider->create(
                    $apiProvider['id'],
                    $apiProvider['access_group_name'],
                    $apiProvider['access_group_id'],
                    $apiProvider['total_uses'],
                    $apiProvider['event_id'],
                    $apiProvider['structure_decode'],
                    $apiProvider['name'],
                    $apiProvider['basic_product_id'],
                    $apiProvider['modified'] !== null ? new DateTime($apiProvider['modified']) : null
                );
            } elseif ($this->needsToBeUpdated($provider->getModified(), $apiProvider['modified'])) {
                $provider->update(
                    $apiProvider['access_group_name'],
                    $apiProvider['access_group_id'],
                    $apiProvider['total_uses'],
                    $apiProvider['event_id'],
                    $apiProvider['structure_decode'],
                    $apiProvider['name'],
                    $apiProvider['basic_product_id'],
                    new DateTime($apiProvider['modified'])
                );
            }

            foreach ($providerSessions as $session) {
                $provider->addSession($session);
            }

            $this->persistProvider($provider);
        }
    }

    protected function persistProvider(Provider $provider)
    {
        $this->em->persist($provider);
        $this->em->flush();
    }

    protected function getDataFromApi()
    {
        $client = HttpClient::create(['headers' => [
            'Authorization' => 'Basic cJmAc71jah17sgqi1jqaksvaksda=',
        ]]);

        $apiProviders = $client->request('GET', 'https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1');

        return $apiProviders->toArray();
    }

    private function needsToBeUpdated(DateTime $current, $new)
    {
        if ((is_null($current) && !is_null($new)) ||
            (!is_null($current) && !is_null($new) && $current->getTimestamp() < (new DateTime($new))->getTimestamp())
        ) {
            return true;
        }

        return false;
    }
}