import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Employee { id?: number; name: string; email: string; }

@Injectable({ providedIn: 'root' })
export class EmployeeService {
  constructor(private http: HttpClient) {}
  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>('http://localhost:8080/employees');
  }
}
