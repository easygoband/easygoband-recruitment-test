import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterComponent } from './filter.component';
import { MatSelectModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TicketService } from '../ticket.service';
import { of } from 'rxjs';
import { Ticket } from '../ticket';

const EXAMPLE_DATA: Ticket[] = [
	{
		'access_group_name': 'Abono',
		'access_group_id': 1,
		'total_uses': 0,
		'sessions': [
			{
				'name': '01-ABONO',
				'id': 19
			}
		],
		'event_id': 1,
		'structure_decode': false,
		'name': 'TKT CE ABONO 95',
		'modified': new Date(),
		'id': 78,
		'basic_product_id': 27
	}, {
		'access_group_name': 'Jueves',
		'access_group_id': 6,
		'total_uses': 0,
		'sessions': [{
			'name': '02-JUEVES',
			'id': 20
		}],
		'event_id': 1,
		'structure_decode': false,
		'name': 'TKT CE JUEVES 70',
		'modified': new Date(),
		'id': 81,
		'basic_product_id': 28
	}];

class TicketServiceStub extends TicketService {
	fetch() {
		return of(EXAMPLE_DATA);
	}
}

const ticketServiceStub = new TicketServiceStub(null);

describe('FilterComponent', () => {
	let component: FilterComponent;
	let fixture: ComponentFixture<FilterComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [FilterComponent],
			providers: [{ provide: TicketService, useValue: ticketServiceStub }],
			imports: [MatSelectModule, BrowserAnimationsModule]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(FilterComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
