import {Component}                   from '@angular/core';
import {Customer}                    from '../../models/customer';
import {addCustomer}                 from '../store/action/customer.actions';
import {clearCustomersStore}         from '../store/action/customer.actions';
import {CustomerState}               from '../store/reducer/customer.reducer';
import {getCustomerActionSuccess }   from '../store/action/customer.actions';
import {getAPICustomers }            from '../store/action/customer.actions';
import {selectCustomers}             from '../store/selector/customer.selectors';
import {select, Store}               from '@ngrx/store';
import {Observable}                  from 'rxjs';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.scss']
})

export class CustomerAddComponent {

  readonly CLEAR    = 0;
  readonly NO_CLEAR = 1;
  counter           = 0;

  constructor(private store: Store<CustomerState>) {
  }

  addCustomer(customerName: string): void {

    if(this.counter == this.CLEAR) {
      this.store.dispatch(clearCustomersStore());
      this.counter = this.NO_CLEAR;
    }

    console.log(this.counter);

    const customer = new Customer();
    customer.name  = customerName;

    this.store.dispatch(addCustomer(customer));
  }

  readCustomersFromAPI(): void {
    this.store.dispatch(new getAPICustomers());
    this.counter = this.CLEAR;
  }

}
