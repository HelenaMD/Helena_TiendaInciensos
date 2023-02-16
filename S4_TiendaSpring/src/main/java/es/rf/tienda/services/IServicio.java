package es.rf.tienda.services;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Nombre: IServicio
 * Descripcion: Interfaz que contiene nuestros propios metodos CRUD y que implementaran nuestros servicios.
 * @author helena.martinez.duro
 * @version 10 de febrero de 2023
 * @param <T> Clase dominio/modelo con la que operaremos
 * @param <S> Tipo de dato Wrapper del id de la clase dominio.
 */
@Service
public interface IServicio<T, S> {
	
	/**
	 * Metodo que insertara un registro T en la bbdd.
	 * @param t objeto de clase dominio
	 * @return boolean
	 */
	public boolean insert(T t);
	
	/**
	 * Metodo que actualizara un registro T en la bbdd.
	 * @param t objeto de clase dominio
	 * @return boolean
	 */
	public boolean update(T t);
	
	/**
	 * Metodo que borrara de la bbdd un registro cuya id coincida con el que recibe por parametros
	 * @param s id del registro a borrar
	 * @return boolean
	 */
	public boolean deleteById(S s);
	
	/**
	 * Metodo que devolvera una lista con todos los objetos de la clase dominio en la que operemos.
	 * @return List<T> donde T es la clase dominio.
	 */
	public List<T> listAll();
	
	/**
	 * Metodo que devuelve un objeto de la clase dominio en la que operemos cuya id coincide con el
	 * parametro recibido.
	 * @param s id del registro a leer
	 * @return T objeto de clase dominio
	 */
	public T leerUno(S s);
}
