import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { from, fromEvent, Observable, of } from 'rxjs';
import { concatMap, delay, exhaustMap, mergeMap, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-operators',
  template: `<button #button>Click Me</button>`,
  styleUrls: ['./operators.component.css']
})
export class OperatorsComponent implements OnInit {

  counter: number = 0;

  constructor() { }

  @ViewChild('button',{static:true}) button;
  clicks$:Observable<any>;

  orders_array = ["pizza", "ice scream", "pasta", "chicken"];

  orderPreparation(order) {
    const delayTime = Math.floor(Math.floor(1 * 10) * 1000);
    //const delayTime = Math.floor(Math.floor(1 * 10) * 1000); 10s for dish
    this.counter=this.counter+1
    return of(`your order ${order} is ready after ${delayTime}`).pipe(delay(delayTime));
  }

  ngOnInit(): void {
    this.clicks$ = fromEvent(this.button.nativeElement, 'click');
    this.clicks$.pipe(
      // try to change to concatMap, mergeMap, switchMap, exhaustMap
      switchMap(
        order => {
          this.resetCounter();
          return this.orderPreparation(this.orders_array[this.counter]);}
        )
      )
      .subscribe((item => console.log(item)));
  }

  resetCounter() {
    const MAX_ORDER = 4;
    if(this.counter >= MAX_ORDER) {
      this.counter = 0
    }
  }

}
