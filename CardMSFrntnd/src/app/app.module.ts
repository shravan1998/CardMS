import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EditCardComponent } from './edit-card/edit-card.component';
import { ViewCardComponent } from './view-card/view-card.component';

@NgModule({
  declarations: [
    AppComponent,
    EditCardComponent,
    ViewCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
