import { Component, OnInit } from '@angular/core';
import { Employee, EmployeeService } from './employee.service';

@Component({
  selector: 'app-employee-list',
  template: `<ul><li *ngFor="let e of employees">{{e.name}} ({{e.email}})</li></ul>`
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];
  constructor(private svc: EmployeeService) {}
  ngOnInit(){ this.svc.getAll().subscribe(list => this.employees = list); }
}
