import { Component, OnInit } from '@angular/core';
import { TicketService } from './ticket.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css'],
	providers: [TicketService]
})
export class AppComponent implements OnInit {
	sessionNames = [];
	session = '';

	constructor(private ticketService: TicketService) {}

	ngOnInit() {
		this.ticketService
			.fetch()
			.toPromise()
			.then(tickets => this.sessionNames = this.uniq(tickets.map(ticket => ticket.sessions[0].name)));
	}

	onSelect(sessionName: string) {
		if (typeof sessionName === 'undefined') {
			this.session = '';
		} else {
			this.session = sessionName;
		}
	}

	// Remove duplicated elements from a list of strings.
	private uniq(list) {
		const seen = {};
		return list.filter(function(item) {
			return seen.hasOwnProperty(item) ? false : (seen[item] = true);
		});
	}
}
