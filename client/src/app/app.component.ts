import { Component, OnInit } from '@angular/core';
import { TicketService } from './ticket.service';
import { Ticket } from './ticket';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css'],
	providers: [TicketService]
})
export class AppComponent implements OnInit {
	sessionNames: string[] = [];
	session: string;

	constructor(private ticketService: TicketService) {}

	ngOnInit() {
		// load the sessionNames from the ticketService
		this.ticketService
			.fetch()
			.subscribe(tickets => {
				this.sessionNames = this.getSessionNames(tickets); },
				err => {console.log(err);
			});
	}

	setFilter(filter: string) {
		// if the user clears the selection, filter will be undefined
		// setting session to empty string means that we clear the filter
		this.session = filter ? filter : '';
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
