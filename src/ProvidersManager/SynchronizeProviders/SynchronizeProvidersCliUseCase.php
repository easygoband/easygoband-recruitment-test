<?php

namespace App\ProvidersManager\SynchronizeProviders;

use App\Entity\Provider;
use Symfony\Component\Console\Helper\ProgressBar;
use Symfony\Component\Console\Output\OutputInterface;

class SynchronizeProvidersCliUseCase extends SynchronizeProvidersUseCase
{
    /* @var ProgressBar $progressBar */
    private $progressBar;

    public function setOutput(OutputInterface $output)
    {
        $apiProvidersSize = count($this->getDataFromApi());
        $output->writeln("$apiProvidersSize providers will be updated");

        $this->progressBar = new ProgressBar($output, $apiProvidersSize);
    }

    protected function persistProvider(Provider $provider)
    {
        parent::persistProvider($provider);
        $this->progressBar->advance();
    }
}