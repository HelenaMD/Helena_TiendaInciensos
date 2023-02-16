package es.rf.tienda.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Modelo;
import es.rf.tienda.exception.DomainException;

/*Clase que será de tipo: 
 * -- Una clase dominio que extiende de Modelo, >(T)<
 * -- Un tipo de dato Wrapper que coincide con el tipo de dato de la PrimaryKey 
 *    del dominio (Ejemplo: Integer). >(S)<
 * -- Una clase repositorio que extiende del JpaRepository<T (Dominio), S (Tipo de dato Wrapper de ID)> >(R)<
 * 
 * Implementa:
 * -- IServicio<T (Dominio), S (Tipo de dato de ID) -> esto proporciona a esta clase los metodos basicos
 *   de CRUD hechos por nosotros: leer uno y todos, modificar, insertar, eliminar.
 * */
public class ServicioGral<T extends Modelo, S, R extends JpaRepository<T, S>> implements IServicio<T, S> {

	/**
	 * Spring instancia un objeto repositorio que en este caso contiene los metodos heredados de
	 * JpaRepository
	 * Sera a quien llamemos para ordenar las operaciones en bbdd.
	 */
	@Autowired
	private R rDao;
	
	/**
	 * Metodo sobreescrito insert implementado de IServicio.
	 */
	@Override
	public boolean insert(T t) {
		if (t.isValidInsert()) {
			rDao.save(t);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo sobreescrito update implementado de IServicio.
	 */
	@Override
	public boolean update(T t) {
		if (t.isValidUpdate()) {
			rDao.save(t);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo sobreescrito deleteById implementado de IServicio.
	 */
	@Override
	public boolean deleteById(S s) {
		try {
			rDao.deleteById(s);
			return true;
		} catch (EmptyResultDataAccessException nsee) {
			return false;
		}
	}

	/**
	 * Metodo sobreescrito listAll implementado de IServicio.
	 */
	@Override
	public List<T> listAll() {
		return rDao.findAll();
	}

	/**
	 * Metodo sobreescrito leerUno implementado de IServicio.
	 */
	@Override
	public T leerUno(S s) {
		try {
			T t = rDao.findById(s).get();
			return t;
		} catch (NoSuchElementException nsee) {
			return null;
		}
	}

}
