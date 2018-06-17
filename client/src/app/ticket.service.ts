import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ticket } from './ticket';

@Injectable({
	providedIn: 'root'
})
export class TicketService {

	constructor(private http: HttpClient) {
		this.http = http;
	}

	fetch() {
		return this.http.get<Ticket[]>('http://localhost:8080');
	}
}
