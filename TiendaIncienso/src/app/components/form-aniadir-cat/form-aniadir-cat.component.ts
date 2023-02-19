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

  categoriaForm: FormGroup = new FormGroup({
    cat_nombre: new FormControl('', [Validators.required]),
    cat_descripcion: new FormControl('')
  });
  categoria: Categoria = {
    id_categoria: 0,
    cat_nombre: "",
    cat_descripcion: ""
  }

  ACTUALIZAR: string = "Actualizar";
  BORRAR: string = "Borrar";
  ANIADIR: string = "Añadir";
  opcion: string = "";
  isReadOnly: boolean = false;
  formType: string = "";
  mens?: MensajeRespuesta<Categoria>;
  catRecogida: Categoria = {
    id_categoria: 0,
    cat_nombre: "",
    cat_descripcion: ""
  }

  id: number = 0;

  constructor(private conexion: ConexionService, private router: Router, private activatedRoute: ActivatedRoute) {

    this.activatedRoute.params.subscribe(params => {
      this.formType = params['act'];
      switch (this.formType) {
        case "add":
          this.opcion = this.ANIADIR;
          break;
        case "del":
          this.opcion = this.BORRAR;
          this.id = params['id'];
          this.isReadOnly = true;
          this.getCategoriaInForm();
          break;
        case "edit":
          this.opcion = this.ACTUALIZAR;
          this.id = params['id'];
          this.getCategoriaInForm();
          break;
        default:
          this.opcion = "invalid";
          break;
      }
    })


  }

  getCategoriaInForm() {
    const dato: Observable<any> = this.conexion.leerTodoApi('categoria/' + this.id);
    console.log("Busco objeto");
    //Recojo datos
    dato.subscribe(
      (resp: any) => {
        //Status http
        let stat: number = resp.code_respuesta;
        //Si ha ido bien
        if (stat == 202) {
          //console.log(this.mens);
          //Recojo primero mi MensajeRespuesta
          this.mens = resp; //as Categoria[];
          //console.log(this.mens);
          //Si mi mensaje respuesta ya tiene contenido
          if (this.mens) {
            //Guardo mis objetos categorias para poder mostrarlos.
            this.catRecogida = this.mens.objeto_dominio;
            console.log("Este es el objeto tras obtenerlo en cat");
            console.log(this.catRecogida);
            //this.hayCategoria = Promise.resolve(true);
          }
        }
        console.log("Muestro el id de la categoria que he pulsado");
        console.log(this.id);

        console.log("Muestro la categoria que he recogido");
        console.log(this.catRecogida);

        console.log("Muestro el formulario sin valores");
        console.log(this.categoriaForm.value);

        this.categoriaForm.get('cat_nombre')?.setValue(this.catRecogida.cat_nombre);
        this.categoriaForm.get('cat_descripcion')?.setValue(this.catRecogida.cat_descripcion);

        console.log("Muestro el formulario CON valores");
        console.log(this.categoriaForm.value);
      }
    )
  }

  ejecutarBbdd() {
    switch (this.opcion) {
      case this.ANIADIR:
        this.altaCategoria();
        break;
      case this.BORRAR:
        this.deleteCategoria();
        break;
      case this.ACTUALIZAR:
        this.actualizarCategoria();
    }
  }
  deleteCategoria() {
    this.categoria = this.categoriaForm.value;
    console.log(this.categoria);
    this.conexion.deleteApi('categoria/' + this.id).subscribe((response: any) => {
      this.router.navigateByUrl("/categoria");
    });
  }

  altaCategoria() {
    this.categoria = this.categoriaForm.value;
    this.conexion.postApi('categoria', this.categoria).subscribe((response: any) => {
      this.router.navigateByUrl("/categoria");
    });
  }

  actualizarCategoria() {
    this.categoria = this.categoriaForm.value;
    this.categoria.id_categoria = this.id;
    console.log(this.categoria);
    this.conexion.putApi('categoria', this.categoria).subscribe((response: any) => {
      this.router.navigateByUrl("/categoria");
    });
  }
}
