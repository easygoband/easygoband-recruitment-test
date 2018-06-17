import { Component, OnInit } from '@angular/core';
import { TicketService } from './ticket.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css'],
	providers: [TicketService]
})
export class AppComponent implements OnInit {
	session: string;

	constructor() {}

	ngOnInit() {}

	setFilter(filter: string) {
		// if the user clears the selection, filter will be undefined
		// setting session to empty string means that we clear the filter
		this.session = filter ? filter : '';
	}
}
