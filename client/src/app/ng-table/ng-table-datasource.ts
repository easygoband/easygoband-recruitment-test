import { DataSource } from '@angular/cdk/collections';
import { MatPaginator, MatSort } from '@angular/material';
import { map } from 'rxjs/operators';
import { Observable, merge } from 'rxjs';

import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';
import { EventEmitter } from '@angular/core';

/**
 * Data source for the NgTable view. This class should
 * encapsulate all logic for fetching and manipulating the displayed data
 * (including sorting, pagination, and filtering).
 */
export class NgTableDataSource extends DataSource<Ticket> {
	data: Ticket[] = [];
	filterEvent = new EventEmitter<string>(true);
	sessionFilter = '';

	constructor(private paginator: MatPaginator, private sort: MatSort, private ticketService: TicketService) {
		super();
		ticketService.fetch().toPromise().then(ticket => this.data = ticket);
	}

	/**
	 * Connect this data source to the table. The table will only update when
	 * the returned stream emits new items.
	 * @returns A stream of the items to be rendered.
	 */
	connect(): Observable<Ticket[]> {
		// Combine everything that affects the rendered data into one update
		// stream for the data-table to consume.
		const dataMutations = [
			this.ticketService.fetch(),
			this.paginator.page,
			this.sort.sortChange,
			this.filterEvent,
		];

		// Set the paginators length
		this.paginator.length = this.data.length;

		return merge(...dataMutations).pipe(map(() => {
			const filteredData = this.getFilteredData(this.getSortedData([...this.data]));
			this.paginator.length = filteredData.length;
			return this.getPagedData(filteredData);
		}));
	}

	/**
	 *  Called when the table is being destroyed. Use this function, to clean up
	 * any open connections or free any held resources that were set up during connect.
	 */
	disconnect() { }

	/**
	 * Paginate the data (client-side). If you're using server-side pagination,
	 * this would be replaced by requesting the appropriate data from the server.
	 */
	private getPagedData(data: Ticket[]) {
		const startIndex = this.paginator.pageIndex * this.paginator.pageSize;
		return data.splice(startIndex, this.paginator.pageSize);
	}

	private getFilteredData(data: Ticket[]) {
		if (this.sessionFilter === '') {
			return data;
		}
		return data.filter(ticket => ticket.sessions[0].name === this.sessionFilter);
	}

	public setFilter(term: string) {
		this.sessionFilter = term;
		this.filterEvent.emit(term);
	}

	/**
	 * Sort the data (client-side). If you're using server-side sorting,
	 * this would be replaced by requesting the appropriate data from the server.
	 */
	private getSortedData(data: Ticket[]) {
		if (!this.sort.active || this.sort.direction === '') {
			return data;
		}

		return data.sort((a, b) => {
			const isAsc = this.sort.direction === 'asc';
			switch (this.sort.active) {
				case 'name': return compare(a.name, b.name, isAsc);
				case 'id': return compare(+a.id, +b.id, isAsc);
				case 'total_uses': return compare(a.total_uses, b.total_uses, isAsc);
				case 'access_group_id': return compare(+a.access_group_id, +b.access_group_id, isAsc);
				case 'access_group_name': return compare(a.access_group_name, b.access_group_name, isAsc);
				case 'basic_product_id': return compare(+a.basic_product_id, +b.basic_product_id, isAsc);
				case 'modified': return compare(a.modified, b.modified, isAsc);
				default: return 0;
			}
		});
	}
}

/** Simple sort comparator for example ID/Name columns (for client-side sorting). */
function compare(a, b, isAsc) {
	return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
