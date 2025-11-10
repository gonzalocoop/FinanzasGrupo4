import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Usuarios } from '../models/Usuarios';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  private url = `${base_url}/usuarios`; // Endpoint del backend

  constructor(private http: HttpClient) { }

  list(): Observable<Usuarios[]> {
    return this.http.get<Usuarios[]>(this.url);
  }

  // Método para buscar un usuario por su username
  findByUsername(username: string): Observable<Usuarios | undefined> {
    return this.list().pipe(
      map(usuarios => usuarios.find(u => u.username === username))
    );
  }
}