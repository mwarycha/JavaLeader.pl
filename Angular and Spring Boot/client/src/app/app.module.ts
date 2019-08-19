import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarListComponent } from './car-list/car-list.component';

import { CarService } from './shared/car/car.service';
import { HttpClientModule } from '@angular/common/http';

import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { GiphyService } from './shared/giphy/giphy.service';
import { CarEditComponent } from './car-edit/car-edit.component';

import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor }   from './shared/okta/auth.interceptor';

import { OktaCallbackComponent, OktaAuthModule } from '@okta/okta-angular';
import { HomeComponent } from './home/home.component';

const config = {
  issuer: 'https://dev-125577.oktapreview.com/oauth2/default/',
  redirectUri: 'http://localhost:4200/implicit/callback',
  clientId: '0oaj7e7dkfx4np1yW0h7'
};

const appRoutes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {
    path: 'home',
    component: HomeComponent
  },
  { path: '', redirectTo: '/car-list', pathMatch: 'full' },
  {
    path: 'car-list',
    component: CarListComponent
  },
  {
    path: 'car-add',
    component: CarEditComponent
  },
  {
    path: 'car-edit/:id',
    component: CarEditComponent
  },
  {
    path: 'implicit/callback',
    component: OktaCallbackComponent
  }
];

@NgModule({

  declarations: [
    AppComponent,
    CarListComponent,
    CarEditComponent,
    HomeComponent
  ],

  imports: [

    BrowserModule,
    AppRoutingModule,
    HttpClientModule,

    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    OktaAuthModule.initAuth(config),
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],

  providers: [CarService,GiphyService, {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [AppComponent],

})
export class AppModule { }
