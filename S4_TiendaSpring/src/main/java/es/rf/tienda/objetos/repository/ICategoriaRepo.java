package es.rf.tienda.objetos.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import es.rf.tienda.dominio.Categoria;

/**
 * Nombre: ICategoriaRepo
 * Descripcion: Interfaz que extiende de JpaRepository creada para poder usar los metodos CRUD de
 * jpa con la clase Categoria.
 * @author helena.martinez.duro
 * @version 10 de febrero de 2023
 * 
 * A JpaRepository se le pasa la clase dominio con la que se va a operar y el tipo de dato Wrapper
 * de la id de la clase dominio.
 */
@Repository
public interface ICategoriaRepo extends JpaRepository<Categoria, Integer>{
	

}
