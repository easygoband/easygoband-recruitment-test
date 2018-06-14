import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { TicketService } from './ticket.service';
import { Ticket } from './ticket';
import { defer } from 'rxjs';

let httpClientSpy: { get: jasmine.Spy };
let ticketService: TicketService;

describe('TicketService', () => {
  beforeEach(() => {
	TestBed.configureTestingModule({
		providers: [TicketService],
		imports: [HttpClientTestingModule]
	});
	httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
	ticketService = new TicketService(<any> httpClientSpy);
  });

  it('should be created', inject([TicketService], (service: TicketService) => {
	expect(service).toBeTruthy();
  }));

  it('should fetch results from server',  () => {
	// tslint:disable-next-line:max-line-length
	const ticket: Ticket[] = [{'access_group_name': 'Abono', 'access_group_id': 1, 'total_uses': 0, 'sessions': [{'name': '01-ABONO', 'id': 19}], 'event_id': 1, 'structure_decode': false, 'name': 'TKT CE ABONO 95', 'modified': new Date(), 'id': 78, 'basic_product_id': 27}];
	httpClientSpy.get.and.returnValue(asyncData(ticket));

	ticketService.fetch().subscribe(result => {
		expect(result).toBe(ticket);
	}, fail);
  });

});

export function asyncData<T>(data: T) {
  return defer(() => Promise.resolve(data));
}
