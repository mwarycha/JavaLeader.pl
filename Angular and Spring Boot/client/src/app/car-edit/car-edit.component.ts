import { Component, OnDestroy, OnInit         } from '@angular/core';
import { Subscription                         } from 'rxjs/Subscription';
import { ActivatedRoute, Router, ParamMap     } from '@angular/router';
import { CarService                           } from '../shared/car/car.service';
import { GiphyService                         } from '../shared/giphy/giphy.service';
import { NgForm                               } from '@angular/forms';
import {switchMap, map, catchError, skipWhile } from 'rxjs/operators';
import { Observable                           } from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/util/pipe';

@Component({
  selector    : 'app-car-edit',
  templateUrl : './car-edit.component.html',
  styleUrls   : ['./car-edit.component.css']
})
export class CarEditComponent implements OnInit,OnDestroy {

  car: any = {};

  sub: Subscription;

  constructor(private route         : ActivatedRoute,
              private router        : Router,
              private carService    : CarService,
              private giphyService  : GiphyService) {
  }

  ngOnInit() {

  this.sub = this.route.paramMap.

        pipe(

          skipWhile((params: ParamMap) => !params),

          switchMap((params: ParamMap) => {
                   return this.carService.get(params.get('id'));
               }),

          map((car: any) => {
              this.car      = car;
              this.car.href = car._links.self.href;
              this.giphyService.get(car.name).subscribe(url => car.giphyUrl = url);
          }),

          catchError((error, caught) => {
              return Observable.throw(error);
           })

        ).subscribe();
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/car-list']);
  }

  save(form: NgForm) {
    this.carService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.carService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
