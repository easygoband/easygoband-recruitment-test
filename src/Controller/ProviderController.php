<?php

namespace App\Controller;

use App\Datatable\ProvidersDatatable;
use Sg\DatatablesBundle\Datatable\DatatableFactory;
use Sg\DatatablesBundle\Response\DatatableResponse;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Exception;

class ProviderController extends AbstractController
{
    private $datatableFactory;
    private $datatableResponse;

    public function __construct(DatatableFactory $datatableFactory, DatatableResponse $datatableResponse)
    {
        $this->datatableFactory = $datatableFactory;
        $this->datatableResponse = $datatableResponse;
    }

    /**
     * @Route("/", name="providers")
     * @param Request $request
     * @return Response
     * @throws Exception
     */
    public function index(Request $request)
    {
        $datatable = $this->datatableFactory->create(ProvidersDatatable::class);
        $datatable->buildDatatable();

        if ($request->isXmlHttpRequest()) {
            $responseService = $this->datatableResponse;
            $responseService->setDatatable($datatable);
            $responseService->getDatatableQueryBuilder();

            return $responseService->getResponse(true, true);
        }

        return $this->render('provider/index.html.twig', ['datatable' => $datatable]);
    }
}
