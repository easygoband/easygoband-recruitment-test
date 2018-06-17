import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';

@Component({
	selector: 'app-filter',
	templateUrl: './filter.component.html',
	styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {
	@Input() sessionNames: string[] = [];
	@Output() filter = new EventEmitter<string>();

	constructor() { }

	ngOnInit() {}

	onSelect(filter: string) {
		this.filter.emit(filter);
	}
}
