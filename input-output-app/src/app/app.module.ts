import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InputComponentComponent } from './input-component/input-component.component';
import { OutputComponentComponent } from './output-component/output-component.component';

@NgModule({
  declarations: [
    AppComponent,
    InputComponentComponent,
    OutputComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
