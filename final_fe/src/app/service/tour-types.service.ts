import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Tour} from '../model/tour.model';
import {TourType} from '../model/tour-type.model';

const API_URL = 'http://localhost:8080/api/tour-types';

@Injectable({
  providedIn: 'root'
})
export class TourTypesService {

  constructor(private httpClient: HttpClient) {
  }
  findAll(): Observable<TourType[]> {
    return this.httpClient.get<TourType[]>(`${API_URL}`);
  }
}
