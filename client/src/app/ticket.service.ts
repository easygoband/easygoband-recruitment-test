import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class TicketService {

	constructor(private http: HttpClient) {
		this.http = http;
	}

	fetch() {
		return this.http.get('localhost:8080');
	}
}
