import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Bound} from '../model/bound.model';

const API_URL = 'http://localhost:8080/api/bounds';

@Injectable({
  providedIn: 'root'
})
export class BoundService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Bound[]> {
    return this.httpClient.get<Bound[]>(`${API_URL}`);
  }
}
