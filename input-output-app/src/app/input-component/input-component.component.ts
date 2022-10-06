import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-input-component',
  templateUrl: './input-component.component.html',
  styleUrls: ['./input-component.component.css']
})
export class InputComponentComponent implements OnInit {

  // non-null assertion operator
  @Input() inputValue! : string;

  @Output() outputValue = new EventEmitter<string>();

  emitEvent(value: string) {
    this.outputValue.emit(value);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
