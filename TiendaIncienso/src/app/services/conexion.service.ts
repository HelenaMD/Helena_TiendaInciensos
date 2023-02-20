import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { share } from 'rxjs/operators';
import { Categoria } from '../components/models/Categoria';
import { MensajeRespuesta } from '../components/models/MensajeRespuesta';

@Injectable({
  providedIn: 'root'
})
export class ConexionService {

  /*Esta es la URL del servidor, la parte backend */
  API_URL:string = 'http://localhost:8080/';

  //Constructor vacio.
  constructor(private http:HttpClient) { }

  /*Este metodo me recoge todos o un objeto dependiendo de la url*/
  leerApi(url:string): Observable<any> {
    return this.http.get(this.API_URL+url).pipe(share());
  }

  /*Este metodo me inserta un objeto*/
  postApi(url:string, obj:any): Observable<any> {
    return this.http.post(this.API_URL+url, obj).pipe(share());
  }

  /*Este metodo me actualiza un objeto de la bbdd*/
  putApi(url:string, obj:any): Observable<any> {
    return this.http.put(this.API_URL+url, obj).pipe(share());
  }

  /*Este metodo me borra un objeto de la bbdd buscandolo por id*/
  deleteApi(url:string): Observable<any> {
    return this.http.delete(this.API_URL+url).pipe(share());
  }
}
