package es.rf.tienda.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.services.ServicioCategoria;
import es.rf.tienda.util.ErrorMessages;

/**
 * Nombre: CategoriaController
 * Descripcion: Controller de la clase Categoria que se encarga de recibir peticiones de cliente 
 * y devolverle respuestas.
 * @author helena.martinez.duro
 * @version 10 de febrero de 2023
 */
@RestController
@CrossOrigin
@RequestMapping("/categoria")
public class CategoriaController {

	/**
	 * Spring instancia un objeto ServicioCategoria que contiene nuestros metodos CRUD
	 * para poder usarlos aqui
	 */
	@Autowired
	private ServicioCategoria cDao;
	
	/**
	 * Metodo que recibe una id y devuelve un objeto MensajeRespuesta que contiene el codigo de respuesta junto
	 * con su mensaje. Si el codigo fue correcto, tambien contiene los datos del objeto que queremos leer.
	 * @param id int
	 * @return MensajeRespuesta<Categoria> Objeto con el mensaje de respuesta y los datos
	 */
	@GetMapping("/{id}")
	public MensajeRespuesta<Categoria> leerUno(@PathVariable("id") String id) {
		MensajeRespuesta<Categoria> resp = new MensajeRespuesta<Categoria>();
		try {
			int idint = Integer.valueOf(id);
			Categoria c = cDao.leerUno(idint);
			if (c == null) {
				resp.setCode_respuesta(HttpStatus.BAD_REQUEST.value());
				resp.setStatus_mensaje(ErrorMessages.CAT_NO_EXISTE);
			} else {
				resp.setCode_respuesta(HttpStatus.ACCEPTED.value());
				resp.setStatus_mensaje(ErrorMessages.OK);
				resp.setObjeto_dominio(c);
			}
			return resp;
		} catch (NumberFormatException nfe) {
			String errMsg = ErrorMessages.BAD_ID;
			resp.setCode_respuesta(HttpStatus.BAD_REQUEST.value());
			resp.setStatus_mensaje(errMsg);
			return resp;
		}
		
	}
	
	/**
	 * Metodo que devuelve todos los objetos existentes de Categoria en una coleccion.
	 * @return List<Categoria>
	 */
	@GetMapping()
	public MensajeRespuestaList<Categoria> leerTodos() {
		MensajeRespuestaList<Categoria> resp = new MensajeRespuestaList<Categoria>();
		resp.setCode_respuesta(HttpStatus.ACCEPTED.value());
		resp.setStatus_mensaje(ErrorMessages.OK);
		resp.setObjeto_dominio(cDao.listAll());
		return resp;
	}
	
	/**
	 * Metodo que inserta una categoria en la bbdd.
	 * @param c Categoria
	 * @return String[] con el codigo de respuesta
	 */
	@PostMapping
	public MensajeRespuesta<Categoria> alta(@RequestBody Categoria c) {
		MensajeRespuesta<Categoria> resp = new MensajeRespuesta<Categoria>();
		c.setId_categoria(0);
		if (cDao.insert(c)) {
			resp.setCode_respuesta(HttpStatus.ACCEPTED.value());
			resp.setStatus_mensaje(ErrorMessages.REGISTRO_SALVADO);
			return resp;
		} else {
			resp.setCode_respuesta(HttpStatus.BAD_REQUEST.value());
			resp.setStatus_mensaje(ErrorMessages.REGISTRO_INVALIDO);
			return resp;
		}
		
	}
	
	/**
	 * Metodo que modifica un registro de la bbdd
	 * @param c Categoria
	 * @return String[] con el codigo de respuesta
	 */
	@PutMapping
	public MensajeRespuesta<Categoria> modificacion(@RequestBody Categoria c) {
		MensajeRespuesta<Categoria> resp = new MensajeRespuesta<Categoria>();
		if (cDao.leerUno(c.getId_categoria()) != null) {
			if(cDao.update(c)) {
				resp.setCode_respuesta(HttpStatus.ACCEPTED.value());
				resp.setStatus_mensaje(ErrorMessages.REGISTRO_MODIF);
				return resp;
			} else {
				resp.setCode_respuesta(HttpStatus.BAD_REQUEST.value());
				resp.setStatus_mensaje(ErrorMessages.REGISTRO_INVALIDO);
				return resp;
			}
		} else {
			resp.setCode_respuesta(HttpStatus.BAD_REQUEST.value());
			resp.setStatus_mensaje(ErrorMessages.REGISTRO_INVALIDO);
			return resp;
		}
		
	}
	
	/**
	 * Metodo que borra un registro de la bbdd segun su id
	 * @param id int
	 * @return String[] con el codigo de respuesta
	 */
	@DeleteMapping("/{id}")
	public MensajeRespuesta<Categoria> borrarPorId(@PathVariable("id") String id) {
		MensajeRespuesta<Categoria> resp = new MensajeRespuesta<Categoria>();
		try {
			int idint = Integer.valueOf(id);
			if(idint > 0 && cDao.deleteById(idint)) {
				resp.setCode_respuesta(HttpStatus.ACCEPTED.value());
				resp.setStatus_mensaje(ErrorMessages.REGISTRO_BORRADO);
				return resp;
			} else {
				resp.setCode_respuesta(HttpStatus.BAD_REQUEST.value());
				resp.setStatus_mensaje(ErrorMessages.REGISTRO_INVALIDO);
				return resp;
			}
		} catch (NumberFormatException nfe) {
			resp.setCode_respuesta(HttpStatus.BAD_REQUEST.value());
			resp.setStatus_mensaje(ErrorMessages.BAD_ID);
			return resp;
		}
		
	}
}
