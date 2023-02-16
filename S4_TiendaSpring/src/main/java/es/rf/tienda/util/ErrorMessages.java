package es.rf.tienda.util;


/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Enero 2016
 *  
 *  @author 	Miguel Garcia
 *  
 *  *****************************************************/
public class ErrorMessages {
	
	
		
	/**
	 * Codigo de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";
	
	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	
	public final static String CAT_NOMBRE_LONGITUD = "El nombre de la categoria debe ser alfanumerico y tener entre "
			+ "5 y 50 caracteres.";
	
	public final static String CAT_DESC_LONGITUD = "La descripcion de la categoria no puede superar los 200 caracteres.";
	
	public final static String CAT_NO_EXISTE = "La categoria que buscas no existe.";
	public final static String BAD_ID = "'?' no es un id valido.";
	
	public final static String OK = "Ok.";
	public final static String REGISTRO_SALVADO = "Registro salvado.";
	public final static String REGISTRO_INVALIDO = "Registro invalido.";
	public final static String REGISTRO_MODIF = "Registro modificado.";
	public final static String REGISTRO_BORRADO = "Registro borrado.";
}
