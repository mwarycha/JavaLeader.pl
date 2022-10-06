import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-output-component',
  templateUrl: './output-component.component.html',
  styleUrls: ['./output-component.component.css']
})
export class OutputComponentComponent implements OnInit {

  outputValue! : string;

  getOutputValue($event: string) {
    this.outputValue = $event;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
