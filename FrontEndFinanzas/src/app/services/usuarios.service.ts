import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Usuarios } from '../models/Usuarios';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { QueryAnalisisRentabilidad } from '../models/QueryAnalisisRentabilidad';
import { QueryCreditosPorUsuarioConPeriododeGracia } from '../models/QueryCreditosPorUsuarioConPeriododeGracia';
import { QueryPrecioCorrespondientePorPropiedadyUsuario } from '../models/QueryPrecioCorrespondientePorPropiedadyUsuario';
import { QueryPropiedadxUserDTO } from '../models/QueryPropiedadxUserDTO';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  private url = `${base_url}/usuarios`;

  constructor(private http: HttpClient) { }

  list(): Observable<Usuarios[]> {
    return this.http.get<Usuarios[]>(this.url);
  }


  findByUsername(username: string): Observable<Usuarios | undefined> {
    return this.list().pipe(
      map(usuarios => usuarios.find(u => u.username === username))
    );
  }

 
  update(u: Usuarios): Observable<any> {
    return this.http.put(this.url, u);
  }

  analisisderentabilidadporcreditodeusuario(id_usuario: number): Observable<QueryAnalisisRentabilidad[]> {
    return this.http.get<QueryAnalisisRentabilidad[]>(`${this.url}/list/analisisderentabilidaddecreditoporusuario?id_usuario=${id_usuario}`);
  }

  creditosporusuarioconperiododegracia(id_usuario: number): Observable<QueryCreditosPorUsuarioConPeriododeGracia[]> {
    return this.http.get<QueryCreditosPorUsuarioConPeriododeGracia[]>(`${this.url}/list/creditosporusuarioconperiododegracia?id_usuario=${id_usuario}`);
  }

  preciocorrespondienteporpropiedadporusuario(id_usuario: number): Observable<QueryPrecioCorrespondientePorPropiedadyUsuario[]> {
    return this.http.get<QueryPrecioCorrespondientePorPropiedadyUsuario[]>(`${this.url}/list/preciocorrespondienteporpropiedadporusuario?id_usuario=${id_usuario}`);
  }

  propiedadesfinanciadasporusuario(id_usuario: number): Observable<QueryPropiedadxUserDTO[]> {
    return this.http.get<QueryPropiedadxUserDTO[]>(`${this.url}/list/propiedadesfinanciadasporusuario?id_usuario=${id_usuario}`);
  }
}