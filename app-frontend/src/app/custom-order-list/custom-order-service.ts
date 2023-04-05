import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CustomOrderDTO } from './custom-order-dto';

@Injectable({
  providedIn: 'root'
})
export class CustomOrderService {
  private apiUrl = 'http://localhost:8080/api/orders/getOrders';

  constructor(private http: HttpClient) {}

  getOrders(status?: string): Observable<CustomOrderDTO[]> {
    let params = new HttpParams();
    if (status) {
      params = params.set('status', status);
    }
    return this.http.get<CustomOrderDTO[]>(this.apiUrl, { responseType: 'json', params: params });
  }
}
