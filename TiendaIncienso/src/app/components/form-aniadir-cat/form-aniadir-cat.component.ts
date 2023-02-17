import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ConexionService } from 'src/app/services/conexion.service';
import { Categoria } from '../models/Categoria';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MensajeRespuesta } from '../models/MensajeRespuesta';

@Component({
  selector: 'app-form-aniadir-cat',
  templateUrl: './form-aniadir-cat.component.html',
  styleUrls: ['./form-aniadir-cat.component.css']
})
export class FormAniadirCatComponent {

  categoriaForm?: FormGroup;
  categoria: Categoria = {
    id_categoria: 0,
    cat_nombre: "",
    cat_descripcion: ""
  }

  actualizar:string = "Actualizar";
  borrar:string = "Borrar";
  aniadir:string = "Añadir";
  opcion:string = "";
  formType:string = "";
  mens?: MensajeRespuesta<Categoria>;
  cat?: Categoria;

  constructor(private conexion: ConexionService, private router: Router, private activatedRoute: ActivatedRoute) {

    this.activatedRoute.params.subscribe(params => {
      this.formType = params['act'];
      switch(this.formType) {
        case "add":
          this.opcion = this.aniadir;
          this.categoriaForm = new FormGroup({
            cat_nombre: new FormControl('', [Validators.required]),
            cat_descripcion: new FormControl(),
          });
          break;
        case "del":
          this.opcion = this.borrar;
          console.log(params['id']);
          this.getCategoria(params['id']);
          this.categoriaForm = new FormGroup({
            cat_nombre: new FormControl(this.cat?.cat_nombre, [Validators.required]),
            cat_descripcion: new FormControl(this.cat?.cat_descripcion),
          });
          break;
        case "edit":
          this.opcion = this.actualizar;
          break;
        default:
          this.opcion = "invalid";
          break;
      }
    })

    
  }
  
  getCategoria(id:number) {
    const dato: Observable<any> = this.conexion.leerTodoApi('categoria/' + id);
    console.log("Busco objeto");
    //Recojo datos
    dato.subscribe(
      (resp: any) => {
        //Status http
        let stat: number = resp.code_respuesta;
        //Si ha ido bien
        if (stat == 202) {
          console.log(this.mens);
          //Recojo primero mi MensajeRespuesta
          this.mens = resp; //as Categoria[];
          console.log(this.mens);
          //Si mi mensaje respuesta ya tiene contenido
          if (this.mens) {
            //Guardo mis objetos categorias para poder mostrarlos.
            this.cat = this.mens.objeto_dominio;
          }
        }
      }
    )
  }

  altaCategoria() {
    if (this.categoriaForm) {
      this.categoria = this.categoriaForm.value;
    this.conexion.postApi('categoria', this.categoria).subscribe((response: any) => {
      this.router.navigateByUrl("/categoria");
    });
    ;//.then(() => window.location.reload);
    }
  }
}
