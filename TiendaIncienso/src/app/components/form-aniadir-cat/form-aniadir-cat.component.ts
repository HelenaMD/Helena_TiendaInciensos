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

  //Declaro e inicializo FormGroup para el formulario compartido
  categoriaForm: FormGroup = new FormGroup({
    cat_nombre: new FormControl('', [Validators.required, Validators.pattern("[A-Za-z ]{5,}")]), //Campo requerido
    cat_descripcion: new FormControl('') //Campo que puede estar vacio.
  });

  //Variable que contendra el objeto para su insercion o para su modificacion
  categoria: Categoria = {
    id_categoria: 0,
    cat_nombre: "",
    cat_descripcion: ""
  }

  //Estados para detectar en que funcion esta el formulario
  ACTUALIZAR: string = "Actualizar"; //Formulario en funcion actualizar
  BORRAR: string = "Borrar"; //Formulario en funcion borrar
  ANIADIR: string = "Añadir"; //Formulario en funcion aniadir
  opcion: string = ""; //Funcion del formulario en el momento
  isReadOnly: boolean = false; //Indica si los campos del formulario serán de solo lectura

  formType: string = ""; //Recoje la parte de la url que me indica qué funcion de formulario necesitamos
  id: number = 0; //Recoge la id de la categoria en la que hemos pulsado.

  mens?: MensajeRespuesta<Categoria>; //Recojo el mensaje respuesta del objeto Categoria

  //Objeto Categoria que recogemos de la base de datos para mostrar sus datos en el formulario
  catRecogida: Categoria = {
    id_categoria: 0,
    cat_nombre: "",
    cat_descripcion: ""
  }

  constructor(private conexion: ConexionService, private router: Router, private activatedRoute: ActivatedRoute) {

    //Esto me pasa la info y datos de la url. Viene inyectado en el constructor
    this.activatedRoute.params.subscribe(params => {
      //Recojo el parametro "act" de la url que me dice desde donde hemos accedido
      this.formType = params['act'];
      switch (this.formType) {
        case "add": //Si estamos en añadir
          this.opcion = this.ANIADIR; //Hago que la opcion esté en "añadir"
          break;
        case "del": //Si estamos en borrar
          this.opcion = this.BORRAR; //Hago que la opcion esté en "borrar"
          this.id = params['id']; //En la funcion de borrar tengo disponible el id del objeto, lo recojo
          this.isReadOnly = true;- //Queremos que los campos sean solo lectura, son solo de informacion
          this.getCategoriaInForm(); //Recogemos el objeto categoria para mostrar sus datos en el formulario
          break;
        case "edit":
          this.opcion = this.ACTUALIZAR; //Si estamos en actualizar
          this.id = params['id']; //En la funcion de actualizar tengo disponible el id del objeto, lo recojo
          this.getCategoriaInForm(); //Recogemos el objeto categoria para mostrar sus datos en el formulario
          break;
        default:
          this.opcion = "invalid"; //Para cuando accedemos desde una url incorrecta
          //Tengo que implementar gestion de errores
          break;
      }
    })


  }

  //Metodo que me recoge un objeto categoria por su id de la bbdd y me setea sus valores al formulario
  //No puedo separar esas funciones por tema hilos, acaba antes el formulario que la recogida de datos.
  getCategoriaInForm() {
    //Recojo observable de leerApi
    const dato: Observable<any> = this.conexion.leerApi('categoria/' + this.id);
    //console.log("Busco objeto");
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
            //console.log("Este es el objeto tras obtenerlo en cat");
            //console.log(this.catRecogida);
            //this.hayCategoria = Promise.resolve(true);
          }
        }
        
        /*console.log("Muestro el id de la categoria que he pulsado");
        console.log(this.id);

        console.log("Muestro la categoria que he recogido");
        console.log(this.catRecogida);

        console.log("Muestro el formulario sin valores");
        console.log(this.categoriaForm.value);*/

        //Pongo los valores del objeto en el formulario para que se muestre
        this.categoriaForm.get('cat_nombre')?.setValue(this.catRecogida.cat_nombre);
        this.categoriaForm.get('cat_descripcion')?.setValue(this.catRecogida.cat_descripcion);

        /*console.log("Muestro el formulario CON valores");
        console.log(this.categoriaForm.value);*/
      }
    )
  }

  //Metodo que según su funcion ejecuta una accion sobre la bbdd
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
  //Metodo que borra una categoria de la bbdd
  deleteCategoria() {
    this.categoria = this.categoriaForm.value; //Esto recoge el valor del formulario y lo convierte a objeto categoria
    //console.log(this.categoria);
    this.conexion.deleteApi('categoria/' + this.id).subscribe((response: any) => {
      this.router.navigateByUrl("/categoria");
    });
  }

  //Metodo que inserta una categoria en la bbdd
  altaCategoria() {
    this.categoria = this.categoriaForm.value; //Esto recoge el valor del formulario y lo convierte a objeto categoria
    this.conexion.postApi('categoria', this.categoria).subscribe((response: any) => {
      this.router.navigateByUrl("/categoria");
    });
  }

  //Metodo que actualiza una categoria de la bbdd
  actualizarCategoria() {
    this.categoria = this.categoriaForm.value; //Esto recoge el valor del formulario y lo convierte a objeto categoria
    this.categoria.id_categoria = this.id; //En este caso necesito la id tambien, la tengo de la url, se la pongo al objeto
    //console.log(this.categoria);
    this.conexion.putApi('categoria', this.categoria).subscribe((response: any) => {
      this.router.navigateByUrl("/categoria");
    });
  }
}
