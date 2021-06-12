import { Injectable }                 from '@angular/core';
import { Actions, Effect, ofType }    from '@ngrx/effects';
import { switchMap, catchError, map } from 'rxjs/operators';
import { of }                         from 'rxjs';
import { CustomerService }            from '../services/customerService';
import { getCustomerActionSuccess }   from '../store/action/customer.actions';
import { getAPICustomers }            from '../store/action/customer.actions';
import { Customer }                   from '../../models/customer';

@Injectable()
export class CustomerEffects {

  constructor(
    private actions: Actions,
    private customerService: CustomerService
  ) { }

  @Effect()
  getAPICustomers = this.actions.pipe(
    ofType('getAPICustomers'),
    switchMap(() =>
      this.customerService.getAPICustomers().pipe(
        map((customers: Array<Customer>) => getCustomerActionSuccess(customers))
      )
    )
  );
}

