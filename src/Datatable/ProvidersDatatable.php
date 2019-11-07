<?php

namespace App\Datatable;

use App\Entity\Provider;
use App\Entity\Session;
use Sg\DatatablesBundle\Datatable\AbstractDatatable;
use Sg\DatatablesBundle\Datatable\Column\Column;
use Sg\DatatablesBundle\Datatable\Column\DateTimeColumn;
use Sg\DatatablesBundle\Datatable\Filter\SelectFilter;
use Sg\DatatablesBundle\Datatable\Style;

/**
 * Classes PostDatatable
 *
 * @package AppBundle\Datatables
 */
class ProvidersDatatable extends AbstractDatatable
{
    /**
     * {@inheritdoc}
     */
    public function buildDatatable(array $options = array())
    {
        $this->features->set(array(
            'auto_width' => true,
            'defer_render' => false,
            'info' => true,
            'length_change' => true,
            'ordering' => true,
            'paging' => true,
            'processing' => true,
            'scroll_x' => false,
            'scroll_y' => '',
            'searching' => true,
            'state_save' => false,
        ));

        $this->ajax->set(array(
            'url' => $this->router->generate('providers'),
            'method' => 'GET'
        ));

        $this->options->set(array(
            'display_start' => 0,
            'defer_loading' => -1,
            'length_menu' => array(10, 25, 50, 100),
            'order_classes' => true,
            'order' => array(array(0, 'asc')),
            'order_multi' => true,
            'page_length' => 10,
            'order_cells_top' => true,
            'paging_type' => Style::FULL_NUMBERS_PAGINATION,
            'renderer' => '',
            'scroll_collapse' => false,
            'search_delay' => 0,
            'state_duration' => 7200,
            'stripe_classes' => array(),
            'classes' => Style::BOOTSTRAP_4_STYLE,
            'individual_filtering' => true,
            'individual_filtering_position' => 'head',
        ));

        $sessions = $this->em->getRepository(Session::class)->findAll();

        $this->columnBuilder
            ->add('id', Column::class, array(
                'title' => 'Id',
                'filter' => array(SelectFilter::class, array('classes' => 'hide-filter'))
            ))
            ->add('accessGroupName', Column::class, array(
                'title' => 'Access Group Name',
                'filter' => array(SelectFilter::class, array('classes' => 'hide-filter'))
            ))
            ->add('accessGroupId', Column::class, array(
                'title' => 'Access Group Id',
                'filter' => array(SelectFilter::class, array('classes' => 'hide-filter'))
            ))
            ->add('totalUses', Column::class, array(
                'title' => 'Total Uses',
                'filter' => array(SelectFilter::class, array('classes' => 'hide-filter'))
            ))
            ->add('sessions.name', Column::class, array(
                'title' => 'Sessions',
                'data' => 'sessions[, ].name',
                'filter' => array(SelectFilter::class, array(
                    'search_type' => 'eq',
                    'select_options' =>
                        array('Select a filter' => 'Select a filter', '' => 'All') +
                        $this->getOptionsArrayFromEntities($sessions, 'name', 'name')
                ))
            ))
            ->add('eventId', Column::class, array(
                'title' => 'Event Id',
                'filter' => array(SelectFilter::class, array('classes' => 'hide-filter'))
            ))
            ->add('structureDecode', Column::class, array(
                'title' => 'Structure Decode',
                'filter' => array(SelectFilter::class, array('classes' => 'hide-filter'))
            ))
            ->add('name', Column::class, array(
                'title' => 'Name',
                'filter' => array(SelectFilter::class, array('classes' => 'hide-filter'))
            ))
            ->add('modified', DateTimeColumn::class, array(
                'title' => 'Modified',
                'filter' => array(SelectFilter::class, array('classes' => 'hide-filter'))
            ))
            ->add('basicProductId', Column::class, array(
                'title' => 'Basic Product Id',
                'filter' => array(SelectFilter::class, array('classes' => 'hide-filter'))
            ))
        ;
    }

    /**
     * {@inheritdoc}
     */
    public function getEntity()
    {
        return Provider::class;
    }

    /**
     * {@inheritdoc}
     */
    public function getName()
    {
        return 'providers_datatable';
    }
}