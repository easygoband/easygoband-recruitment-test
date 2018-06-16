import { fakeAsync, ComponentFixture, TestBed, async, tick } from '@angular/core/testing';

import { NgTableComponent } from './ng-table.component';
import { TicketService } from '../ticket.service';
import { MatTableModule, MatPaginatorModule, MatSortModule, MatCardModule, MatSelectModule } from '@angular/material';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Ticket } from '../ticket';
import { of } from 'rxjs';
import { BrowserModule } from '@angular/platform-browser';
import { CdkTableModule } from '@angular/cdk/table';

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

describe('NgTableComponent', () => {
	let component: NgTableComponent;
	let fixture: ComponentFixture<NgTableComponent>;

	beforeEach(fakeAsync(() => {
		TestBed.configureTestingModule({
			providers: [{ provide: TicketService, useValue: ticketServiceStub }],
			declarations: [
				NgTableComponent,
			],
			imports: [
				CdkTableModule,
				BrowserModule,
				MatTableModule,
				MatPaginatorModule,
				MatSortModule,
				MatCardModule,
				MatSelectModule,
				HttpClientTestingModule,
				BrowserAnimationsModule,
			]
		})
			.compileComponents();

		fixture = TestBed.createComponent(NgTableComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	}));

	it('should compile', () => {
		expect(component).toBeTruthy();
	});

	it('should populate the table', () => {
		expect(component.dataSource.data.length).toBe(2);
	});

	it('should have ViewChild defined', () => {
		expect(fixture.componentInstance.paginator).toBeDefined();
		expect(fixture.componentInstance.sort).toBeDefined();
	});

	it('should display the tickets', () => {
		fixture.detectChanges();
		const el: HTMLElement = fixture.nativeElement;
		const rows = el.querySelectorAll('mat-row');
		expect(rows.length).toBe(2);
	});
});
