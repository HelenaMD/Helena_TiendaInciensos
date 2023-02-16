package es.rf.tienda.services;

import es.rf.tienda.objetos.repository.ICategoriaRepo;

import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;

/*Categoria es el modelo o dominio, el que contiene los campos de datos y se transforma a tabla
 * Integer corresponde al tipo de dato del dominio, que en Categoria es un int
 * ICategoriaRepo es el repositorio que extiende de JpaRepository, que nos proporciona
 *  los metodos de interaccion con la bbdd: save, findAll, deleteById...
 *  
 *  Desde el controlador llamaremos a este servicio, ya que al heredar de ServicioGral contiene todos los
 *  metodos necesarios CRUD
 */
@Service
public class ServicioCategoria extends ServicioGral<Categoria, Integer, ICategoriaRepo>{

}
