import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatButtonModule, MatCardModule, MatFormFieldModule, MatIconModule, MatInputModule, MatToolbarModule,
  MatTooltipModule
} from '@angular/material';
import { NavbarComponent } from './navbar/navbar.component';
import { ItemsViewerComponent } from './items-viewer/items-viewer.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {AvatarModule} from 'ngx-avatar';
const routes: Routes = [
  {
    path: 'items-viewer',
    component: ItemsViewerComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ItemsViewerComponent,
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule, MatButtonModule,
    MatIconModule, MatTooltipModule, HttpClientModule, MatCardModule,
    RouterModule.forRoot(routes), AvatarModule,
    MatToolbarModule, MatFormFieldModule, MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
