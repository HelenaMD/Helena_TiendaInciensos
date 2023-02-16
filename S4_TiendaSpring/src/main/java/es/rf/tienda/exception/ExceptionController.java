package es.rf.tienda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.rf.tienda.controller.MensajeRespuesta;

/**
 * Nombre: ExceptionController
 * Descripcion: Clase que recoge todas las excepciones internas de spring imposibles de capturar
 * con un try-catch tradicional
 * @author helena.martinez.duro
 * Version: 14 de febrero de 2023
 */
@CrossOrigin
@ControllerAdvice
public class ExceptionController {
	
	/**
	 * Metodo que recoge las excepciones anotadas en @ExceptionHandler y plasma sus datos en un objeto
	 * MensajeRespuesta<String>
	 * @param ex la exception
	 * @return MensajeRespuesta<String>
	 */
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody MensajeRespuesta<String> handleException(HttpMessageNotReadableException ex) {
		MensajeRespuesta<String> respuesta = new MensajeRespuesta<String>();
		respuesta.setCode_respuesta(HttpStatus.BAD_REQUEST.value());
		respuesta.setStatus_mensaje(ex.getMessage());
		return respuesta;
	}

}
