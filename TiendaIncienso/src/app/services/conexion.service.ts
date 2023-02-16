import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { share } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ConexionService {

  API_URL:string = 'http://localhost:8080/';

  constructor(private http:HttpClient) { }

  leerApi(url:string): Observable<any> {
    return this.http.get(this.API_URL+url).pipe(share());
  }

  /*postApi(url:string): Observable<any> {
    return this.http.post(this.API_URL+url).pipe(share());
  }

  putApi(url:string): Observable<any> {
    return this.http.put(this.API_URL+url).pipe(share());
  }

  deleteApi(url:string): Observable<any> {
    return this.http.get(this.API_URL+url).pipe(share());
  }*/
}
