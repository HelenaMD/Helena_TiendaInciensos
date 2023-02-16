package es.rf.tienda.controller;

import java.util.List;

/**
 * Nombre: MensajeRespuesta
 * Descripcion: Clase que contiene un mensaje de respuesta a cliente y el objeto de clase dominio
 *  con los datos a mostrar a cliente.
 * @author helena.martinez.duro
 * @version 10 de febrero de 2023
 * @param List<T> Lista de Clases dominio
 */
public class MensajeRespuestaList<T> {
	
	/**
	 * Codigo de respuesta a cliente.
	 */
	private int code_respuesta;

	/**
	 * Mensaje de estado de respuesta para cliente
	 */
	private String status_mensaje;
	
	/**
	 * Objeto a retornar a cliente
	 */
	private List<T> objeto_dominio;
	
	/**
	 * Contructor con parametros
	 * @param status_mensaje String
	 * @param objeto_dominio T objeto de clase dominio
	 */
	public MensajeRespuestaList(String status_mensaje, List<T> objeto_dominio, int code_respuesta) {
		setStatus_mensaje(status_mensaje);
		setObjeto_dominio(objeto_dominio);
		setCode_respuesta(code_respuesta);
	}
	
	/**
	 * Constructor sin parametros
	 */
	public MensajeRespuestaList() {
		setStatus_mensaje(null);
		setObjeto_dominio(null);
		setCode_respuesta(0);
	}

	/**
	 * Getter de status_mensaje
	 * @return String
	 */
	public String getStatus_mensaje() {
		return status_mensaje;
	}
	
	/**
	 * Setter de status mensaje
	 * @param status_mensaje String
	 */
	public void setStatus_mensaje(String status_mensaje) {
		this.status_mensaje = status_mensaje;
	}
	
	/**
	 * Getter de objeto_dominio
	 * @return T objeto de clase dominio
	 */
	public List<T> getObjeto_dominio() {
		return objeto_dominio;
	}
	
	/**
	 * Setter de objeto_dominio
	 * @param objeto_dominio T objeto de clase dominio
	 */
	public void setObjeto_dominio(List<T> objeto_dominio) {
		this.objeto_dominio = objeto_dominio;
	}

	/**
	 * Getter de code_respuesta
	 * @return int
	 */
	public int getCode_respuesta() {
		return code_respuesta;
	}

	/**
	 * Setter de code_respuesta
	 * @param code_respuesta int
	 */
	public void setCode_respuesta(int code_respuesta) {
		this.code_respuesta = code_respuesta;
	}
	
	
}
