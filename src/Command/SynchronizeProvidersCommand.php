<?php

namespace App\Command;

use App\ProvidersManager\SynchronizeProviders\SynchronizeProvidersCliUseCase;
use Symfony\Component\Console\Command\Command;
use Symfony\Component\Console\Input\InputInterface;
use Symfony\Component\Console\Output\OutputInterface;

class SynchronizeProvidersCommand extends Command
{
    protected static $defaultName = 'app:synchronize-providers';

    /* @var SynchronizeProvidersCliUseCase $synchronizeProvidersCliUseCase */
    private $synchronizeProvidersCliUseCase = null;

    public function __construct(SynchronizeProvidersCliUseCase $synchronizeProvidersCli, string $name = null)
    {
        parent::__construct($name);
        $this->synchronizeProvidersCliUseCase = $synchronizeProvidersCli;
    }

    protected function execute(InputInterface $input, OutputInterface $output)
    {
        $this->synchronizeProvidersCliUseCase->setOutput($output);
        $this->synchronizeProvidersCliUseCase->execute();
    }
}