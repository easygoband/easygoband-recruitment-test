import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { TicketService } from '../ticket.service';
import { Ticket } from '../ticket';

@Component({
	selector: 'app-filter',
	templateUrl: './filter.component.html',
	styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {
	sessionNames: string[] = [];
	@Output() filter = new EventEmitter<string>();

	constructor(private ticketService: TicketService) { }

	ngOnInit() {
		// load the sessionNames from the ticketService
		this.ticketService
			.fetch()
			.subscribe(tickets => {
				this.sessionNames = this.getSessionNames(tickets); },
				err => {console.log(err);
			});
	}

	onSelect(filter: string) {
		this.filter.emit(filter);
	}

	// get unique session names from tickets
	private getSessionNames(tickets: Ticket[]) {
		// Remove duplicated elements from a list of strings.
		function unique(list) {
			const seen = {};
			return list.filter(function(item) {
				return seen.hasOwnProperty(item) ? false : (seen[item] = true);
			});
		}
		return unique(tickets.map(ticket => ticket.sessions[0].name));
	}
}
