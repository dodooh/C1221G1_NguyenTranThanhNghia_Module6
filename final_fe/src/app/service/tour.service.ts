import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Tour} from '../model/tour.model';
import {Statistic} from '../model/statistic.model';

const API_URL = 'http://localhost:8080/api/tours';

@Injectable({
  providedIn: 'root'
})
export class TourService {

  constructor(private httpClient: HttpClient) {
  }

  findAllList(page): Observable<Tour[]> {
    return this.httpClient.get<Tour[]>(`${API_URL}?page=${page}`);
  }

  create(tour: any): Observable<any> {
    return this.httpClient.post<any>(`${API_URL}`, tour);
  }
  delete(tourId: string): Observable<any> {
    return this.httpClient.delete<any>(`${API_URL}/${tourId}`, );
  }

  getStatistic(): Observable<Statistic[]> {
    return this.httpClient.get<Statistic[]>(`${API_URL}/statistic`);
  }

}
