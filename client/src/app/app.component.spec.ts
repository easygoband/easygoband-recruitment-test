import { TestBed, ComponentFixture, fakeAsync } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { MatCardModule, MatSelectModule, MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';
import { NgTableComponent } from './ng-table/ng-table.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TicketService } from './ticket.service';
import { Ticket } from './ticket';
import { of } from 'rxjs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
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

describe('AppComponent', () => {
	let component: AppComponent;
	let fixture: ComponentFixture<AppComponent>;
	beforeEach(fakeAsync(() => {
		TestBed.configureTestingModule({
			providers: [{ provide: TicketService, useValue: ticketServiceStub }],
			declarations: [
				AppComponent,
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
				BrowserAnimationsModule
			]
		}).compileComponents();

		fixture = TestBed.createComponent(AppComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	}));

	it('should create the app', () => {
		const app = fixture.debugElement.componentInstance;
		expect(app).toBeTruthy();
	});

});
