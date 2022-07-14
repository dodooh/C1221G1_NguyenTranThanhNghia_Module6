import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Tour} from '../model/tour.model';
import {Customer} from '../model/customer.model';

const API_URL = 'http://localhost:8080/api/customers';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) { }

  findAllList(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(`${API_URL}`);
  }
}
