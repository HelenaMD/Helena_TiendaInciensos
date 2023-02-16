import { Component } from '@angular/core';
import { ConexionService } from './services/conexion.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TiendaIncienso';
  /*listado: any[] = [];

  constructor(private conexion: ConexionService) {
    const dato: Observable<any> = this.conexion.leerApi('categoria');

    console.log("Entro en listado");
    dato.subscribe((resp: any) => {
      this.listado = resp;
      console.log(this.listado);
    })
  }*/
}
