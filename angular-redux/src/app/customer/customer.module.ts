import {NgModule}                       from '@angular/core';
import {CommonModule}                   from '@angular/common';
import {CustomerViewComponent}          from './customer-view/customer-view.component';
import {CustomerAddComponent}           from './customer-add/customer-add.component';
import {StoreModule}                    from '@ngrx/store';
import {customerFeatureKey,reducer}     from './store/reducer/customer.reducer';
import { CustomerEffects }              from './effects/customer.effect';
import { EffectsModule }                from '@ngrx/effects';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@NgModule({
  declarations: [CustomerViewComponent, CustomerAddComponent],
  imports: [
    HttpClientModule,
    CommonModule,
    StoreModule.forFeature(customerFeatureKey, reducer),
    EffectsModule.forRoot([]),
    EffectsModule.forFeature([CustomerEffects])
  ],
  exports: [
    CustomerViewComponent,
    CustomerAddComponent
  ]
})
export class CustomerModule {
}
