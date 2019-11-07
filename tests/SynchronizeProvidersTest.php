<?php

namespace App\Tests;

use App\Entity\Session;
use App\ProvidersManager\SynchronizeProviders\SynchronizeProvidersUseCase;
use Doctrine\ORM\EntityManager;
use Doctrine\ORM\EntityRepository;
use PHPUnit\Framework\MockObject\MockObject;
use PHPUnit\Framework\TestCase;

class SynchronizeProvidersTest extends TestCase
{
    private function getEntityManagerMock()
    {
        $entityRepositoryMock = $this->createMock(EntityRepository::class);
        $entityRepositoryMock->expects($this->at(0))
            ->method('find')
            ->with(4003)
            ->willReturn(new Session());
        $entityRepositoryMock->expects($this->at(1))
            ->method('find')
            ->with(4001)
            ->willReturn(null);

        $entityManagerMock = $this->createMock(EntityManager::class);
        $entityManagerMock->expects($this->once())
            ->method('persist')
            ->willReturn(true);
        $entityManagerMock->expects($this->once())
            ->method('flush')
            ->willReturn(true);
        $entityManagerMock->expects($this->exactly(2))
            ->method('getRepository')
            ->willReturn($entityRepositoryMock);

        return $entityManagerMock;
    }

    public function testSynchronizeProviders()
    {
        $entityManagerMock = $this->getEntityManagerMock();

        /* @var SynchronizeProvidersUseCase|MockObject $synchronizeProviderUseCaseMock */
        $synchronizeProviderUseCaseMock = $this->getMockBuilder(SynchronizeProvidersUseCase::class)
            ->setConstructorArgs([$entityManagerMock])
            ->disableOriginalClone()
            ->disableArgumentCloning()
            ->disallowMockingUnknownTypes()
            ->setMethods(['getDataFromApi'])
            ->getMock();

        $synchronizeProviderUseCaseMock->expects($this->once())
            ->method('getDataFromApi')
            ->willReturn(
                [
                    [
                        'id' => 4001,
                        'access_group_name' => 'testGroup',
                        'access_group_id' => 4002,
                        'total_uses' => 20,
                        'sessions' => [
                            [
                                'name' => 'sessionTest',
                                'id' => 4003
                            ]
                        ],
                        'event_id' => 4004,
                        'structure_decode' => false,
                        'name' => 'test',
                        'basic_product_id' => 4005,
                        'modified' => null
                    ]
                ]
            );

        $synchronizeProviderUseCaseMock->execute();
    }
}