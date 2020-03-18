import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { OnInit } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  title = 'JavaLeaderAngularApp';
  constructor(private apiService: ApiService) { }

  employees;

  ngOnInit() {
      this.apiService.getEmployees().subscribe((data)=>{
        this.employees = data;
      });
}
}
