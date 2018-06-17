import { Component, OnInit, ViewChild, Input, OnChanges, SimpleChanges } from '@angular/core';
import { MatPaginator, MatSort } from '@angular/material';
import { NgTableDataSource } from './ng-table-datasource';
import { TicketService } from '../ticket.service';

@Component({
	selector: 'app-ng-table',
	templateUrl: './ng-table.component.html',
	styleUrls: ['./ng-table.component.css']
})
export class NgTableComponent implements OnInit, OnChanges {
	@ViewChild(MatPaginator) paginator: MatPaginator;
	@ViewChild(MatSort) sort: MatSort;
	dataSource: NgTableDataSource;
	@Input() filter;

	/** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
	displayedColumns = ['id', 'name', 'total_uses', 'session_name', 'access_group_id', 'access_group_name', 'basic_product_id', 'modified'];

	constructor(private ticketService: TicketService) { }

	ngOnInit() {
		this.dataSource = new NgTableDataSource(this.paginator, this.sort, this.ticketService);
	}

	ngOnChanges(changes: SimpleChanges) {
		if (changes.filter.isFirstChange()) {
			return;
		}
		this.dataSource.setFilter(changes.filter.currentValue);
	}

}
