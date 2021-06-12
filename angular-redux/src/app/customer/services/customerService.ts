import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { headers }    from '../headers/headers';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  getAPICustomers() {
    return this.http.get('http://localhost:3000/customers', { headers })
      .pipe(catchError((error: any) => throwError(error.message)));
  }
}

