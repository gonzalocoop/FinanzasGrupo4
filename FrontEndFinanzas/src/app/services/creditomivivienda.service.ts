import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
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

  // --- REGISTRO (Corregido) ---
  registrarCreditoMiVivienda(
    creditoData: any, 
    idPrecioCorrespondiente: number,
    idUsuario: number
  ): Observable<any> { 
    
    let params = new HttpParams()
      .set('cok', creditoData.cok)
      .set('fechaInicio', creditoData.fecha_inicio)
      .set('tipoTasa', creditoData.tipo_tasa)
      .set('tasaInteres', creditoData.tasa_interes)
      .set('periodicidadTasa', creditoData.peridiocidad_tasa)
      .set('numeroCuotas', creditoData.numero_cuotas)
      .set('tipoGracia', creditoData.tipo_gracia)
      .set('duracionGraciaMeses', creditoData.duracion_gracia_meses)
      .set('tipoCapitalizacion', creditoData.tipo_capitalizacion)
      .set('idPrecioCorrespondiente', idPrecioCorrespondiente.toString())
      .set('idUsuario', idUsuario.toString());

    // El backend devuelve 'void', por eso esperamos 'text'
    return this.http.post<any>(`${this.url}/generarcreditovacio`, null, { params: params, responseType: 'text' as 'json' });
  }
  
  // --- LISTAR Y CRUD (Sin cambios) ---
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

  // --- MÉTODOS DE CÁLCULO (Corregidos) ---
  
  // 1. Generar TEM (devuelve 'void')
  generarTEM(id_credito: number): Observable<any> {
    let params = new HttpParams().set('id_credito', id_credito.toString());
    // Añadimos responseType: 'text'
    return this.http.post(`${this.url}/generartem`, null, { params: params, responseType: 'text' as 'json' });
  }
  
  // 2. Generar Cronograma (devuelve String)
  generarCronograma(id_credito: number): Observable<any> {
    let params = new HttpParams().set('id_credito', id_credito.toString());
    // Añadimos responseType: 'text'
    return this.http.post(`${this.url}/generarcronograma`, null, { params: params, responseType: 'text' as 'json' });
  }
  
  // 3. Calcular VAN y TIR (devuelve String)
  calcularVanTir(id_credito: number): Observable<any> {
    let params = new HttpParams().set('id_credito', id_credito.toString());
    // Añadimos responseType: 'text'
    return this.http.post(`${this.url}/calcularvanytir`, null, { params: params, responseType: 'text' as 'json' });
  }
  
  // 4. Calcular TEA y TCEA (devuelve 'void')
  convertirTasasAnuales(id_credito: number): Observable<any> {
    let params = new HttpParams().set('id_credito', id_credito.toString());
    // Añadimos responseType: 'text'
    return this.http.put(`${this.url}/calcularteatcea`, null, { params: params, responseType: 'text' as 'json' });
  }
}