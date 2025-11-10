import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { CreditoMiVivienda } from '../models/CreditoMiVivienda';
import { Observable } from 'rxjs';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class CreditomiviviendaService {
  private url = `${base_url}/creditomivivienda`;

  constructor(private http: HttpClient) { }

  insert(c: CreditoMiVivienda): Observable<CreditoMiVivienda> {
    return this.http.post<CreditoMiVivienda>(this.url, c);
  }

  list(): Observable<CreditoMiVivienda[]> {
    return this.http.get<CreditoMiVivienda[]>(this.url);
  }
  
  listId(id: number): Observable<CreditoMiVivienda> {
    return this.http.get<CreditoMiVivienda>(`${this.url}/${id}`);
  }

  update(c: CreditoMiVivienda): Observable<CreditoMiVivienda> {
    return this.http.put<CreditoMiVivienda>(this.url, c);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
}