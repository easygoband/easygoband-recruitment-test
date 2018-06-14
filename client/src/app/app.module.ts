import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgTableComponent } from './ng-table/ng-table.component';
import { MatTableModule,
	 MatPaginatorModule,
	 MatSortModule,
	 MatCardModule,
	 MatSelectModule } from '@angular/material';

@NgModule({
  declarations: [
	AppComponent,
	NgTableComponent
  ],
  imports: [
	BrowserModule,
	HttpClientModule,
	BrowserAnimationsModule,
	MatTableModule,
	MatPaginatorModule,
	MatSortModule,
	MatCardModule,
	MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
