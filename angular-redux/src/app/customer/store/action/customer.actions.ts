import { createAction, props } from '@ngrx/store';
import { Customer }            from '../../../models/customer';
import { Action }              from '@ngrx/store';

export const addCustomer = createAction(
  '[Customer] Add Customer',
  (customer: Customer) => ({customer})
);

export const clearCustomersStore = createAction(
  '[Customer] Clear Customer store',
  () => ({})
);

export const getCustomerActionSuccess = createAction(
  '[Customer] Get Customer',
  (payload: Array<Customer>) => (
  {payload}
  )
);

export class getAPICustomers implements Action {
  readonly type = 'getAPICustomers';
}

