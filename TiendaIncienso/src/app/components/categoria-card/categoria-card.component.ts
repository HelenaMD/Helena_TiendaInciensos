import { Component } from '@angular/core';
import { ConexionService } from 'src/app/services/conexion.service';
import { Observable } from 'rxjs';
import { Categoria } from '../models/Categoria';
import { MensajeRespuesta } from '../models/MensajeRespuesta';
import { MensajeRespuestaList } from '../models/MensajeRespuestaList';

@Component({
  selector: 'app-categoria-card',
  templateUrl: './categoria-card.component.html',
  styleUrls: ['./categoria-card.component.css']
})
export class CategoriaCardComponent {

  //Variables que van a recoger mis JSON
  listadoMens?: MensajeRespuestaList<Categoria>;
  listadoCat?: Categoria[] = [];
  //Info para el usuario si no encuentra resultados
  vacio?:string;

  constructor(private conexion: ConexionService) {
    console.log("Me ejecuto");
    this.getCategorias();
  }

  /*ngDoCheck() {
    this.getCategorias();
  }*/

  getCategorias() {
    const dato: Observable<any> = this.conexion.leerTodoApi('categoria');
    console.log("Entro en listado");
    //Recojo datos
    dato.subscribe(
      (resp: any) => {
        //Status http
        let stat: number = resp.code_respuesta;
        //Si ha ido bien
        if (stat == 202) {
          console.log(this.listadoMens);
          //Recojo primero mi MensajeRespuesta
          this.listadoMens = resp; //as Categoria[];
          console.log(this.listadoMens);
          //Si mi mensaje respuesta ya tiene contenido
          if (this.listadoMens) {
            //Guardo mis objetos categorias para poder mostrarlos.
            this.listadoCat = this.listadoMens.objeto_dominio;
          }
        } else {
          //Este sera el mensaje cuando no haya nada
          this.vacio = "No se han encontrado resultados."
        }
      }
    )
  }
}
