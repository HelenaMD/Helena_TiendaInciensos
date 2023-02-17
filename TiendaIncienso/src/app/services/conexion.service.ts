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

  API_URL:string = 'http://localhost:8080/';

  constructor(private http:HttpClient) { }

  leerTodoApi(url:string): Observable<any> {
    return this.http.get(this.API_URL+url).pipe(share());
  }

  postApi(url:string, obj:any): Observable<any> {
    return this.http.post(this.API_URL+url, obj).pipe(share());
  }

  /*putApi(url:string): Observable<any> {
    return this.http.put(this.API_URL+url).pipe(share());
  }

  deleteApi(url:string): Observable<any> {
    return this.http.get(this.API_URL+url).pipe(share());
  }*/
}
