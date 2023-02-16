package es.rf.tienda.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



/** ******************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: 
 * 			Clase auxiliar para validar los datos que sean 
 * 			introducidos en la aplicaci�n.
 * 
 *  @version	27/01/2023 
 *  @author 	Helena Martinez Duro
 *  
 * ******************************************************************************************/
public class Validator {
	
	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z ]+$";
	
	private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patr�n para validar el email, evitando puntos finales antes de la @ y que solo contenga
	 * car�cteres alfanum�ricos		 
	 */
	private final static String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	/**
	 * Permite verificar que un DNI cumple con el patr�n XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";
		
	/**
	 * Permite validar un tel�fono, el cual debe contener de 10 a 20 d�gitos
	 * y donde los espacios est�n permitidos
	 */
	private final static String PHONE_PATTERN =  "[\\d ]{10,20}";
	
	/**
	 * Orden de las letras con las cuales se comprobar� la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	/**
	 * Longitud que debe tener todo DNI pasado a la aplicaci�n.
	 */
	private final static int LONGITUD_DNI = 12;
	
	/**
	 * Patron que debe cumplir el codigo de producto.
	 */
	private final static String PRODUCTO_PATTERN = "[A-Z]{2}\\d{3}";

	/** ***************************************************************************************
	 * NOMBRE: isAlfanumeric                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Permite verificar que el texto pasado solo contiene caracters alfanum�ricos
	 * 
	 * @param texto String a verificar que solo tenga car�cteres alfanum�ricos
	 * 
	 * @return  true, si cumple solo contiene caracters alfanum�ricos. <br> 
	 * 			false en caso contrario
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Helena Martinez Duro - Madrid
	 * 
	 * **************************************************************************************/
	public static boolean isAlfanumeric(String texto){
		//Si el texto no es nulo y solo tiene letras y numeros (debe contener al menos 1)
		if (comprobarNulo(texto) && texto.matches(ALFANUMERIC_PATTERN)) {
			//Devuelve true
			return true;
		}
		return false;
	}
	
	public static boolean isVacio(String prueba){
		if (comprobarNulo(prueba) && !prueba.equalsIgnoreCase("")) {
			return false;
		}
		return true;
	}
	
	/** ***************************************************************************************
	 * NOMBRE: cumplePhoneNumber                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		El phone number debe tener un total de entre 10 y 20, contando d�gitos y espacios.
	 * 		M�nimo aceptable son 10 d�gitos.
	 * 
	 * @param phoneNumber String con el n�mero de telefono de entre 10 y 20 d�gitos. 
	 * 		Puede tener espacios, pero siempre con 10 d�gitos como m�nimo.
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 * FECHA: Enero 2023
	 * AUTOR: Helena Martinez Duro - Madrid
	 * 
	 * **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber){
		
		if (comprobarNulo(phoneNumber) && //Si el string no es nulo y cumple con la longitud entre los valores pedidos
				cumpleLongitud(phoneNumber, 10, 20) && // y encaja con la longitud pedida
				phoneNumber.matches(PHONE_PATTERN) &&  // y encaja con el patron de telefono
				cumpleLongitudMin(phoneNumber.replaceAll(" ", ""), 10)) { //Y encaja en la longitud de digitos
			return true; //Devuelve true
		}
		//Si falla alguna condicion devuelve false
		return false;
	}

	/** ***************************************************************************************
	 * NOMBRE: isEmailValido                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 			Comprueba si el email tiene un formato que pueda ser v�lido.
	 * 
	 * @param email String a comprobar
	 * 
	 * @return true, en caso que el formato sea v�lido
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Helena Martinez Duro - Madrid
	 * 
	 * **************************************************************************************/
	public static boolean isEmailValido(String email){
		/*Si el email no es nulo y encaja con el patron de email devuelve true*/
		if (comprobarNulo(email) && email.matches(EMAIL_PATTERN)) {
			return true;
		}
		return false;
	}

	/** ***************************************************************************************
	 * NOMBRE: cumpleDNI                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 			Esta funci�n verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L <br>
	 * 			El DNI ha de tener longitud 12
	 * 
	 * @param dni String con DNI a ser validado
	 * 
	 * @return true, si el DNI cumple el estandar nacional.
	 * FECHA: Enero 2023
	 * AUTOR: Helena Martinez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleDNI(String dni){
		/*Si:
		 * - dni no es nulo
		 * - dni Encaja en el patron de dni
		 * - La letra del dni es una letra valida de la lista de letras
		 * entonces devuelve true*/
		String letraDni = String.valueOf(dni.charAt(dni.length()-1));
		if (comprobarNulo(dni) && dni.matches(DNI_PATTERN) && LETRA_DNI.contains(letraDni) &&
				dni.length() == LONGITUD_DNI) {
			if (comprobarNumeroLetraCorrectoDNI(letraDni, dni)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que coge el valor numerico del dni, calcula cual seria su letra 
	 * correspondiente y confirma que es igual a la letra recibida
	 * @param letra String
	 * @param dni String
	 * @return boolean
	 */
	public static boolean comprobarNumeroLetraCorrectoDNI(String letra, String dni) {
		int soloNums = Integer.valueOf(dni.replaceAll("[A-Za-z.-]", ""));
		
		if (String.valueOf(LETRA_DNI.charAt(soloNums%23)).equalsIgnoreCase(letra)) {
			return true;
		}
		return false;
	}
	

	/** ***************************************************************************************
	 * NOMBRE: cumpleRango                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprueba que un N�mero se necuentra entre 2 valores
	 * 
	 * @param valor (int)/(double) N�mero a comprobar
	 * @param valorMinimo (int) N�mero valor aceptable
	 * @param valorMaximo (int) M�N�mero valor aceptable
	 * 
	 * @return true si valorMinimo > valor > valorMaximo
	 * FECHA: Enero 2023
	 * AUTOR: Helena Martinez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleRango(
			int valor, 
			int valorMinimo,
			int valorMaximo){
		//Utilizo el otro metodo
		double v = valor;
		return cumpleRango(v, valorMinimo, valorMaximo);
	}
	public static boolean cumpleRango(
			double valor, 
			int valorMinimo,
			int valorMaximo){
		//Si valor es mayor o igual que valorMinimo y valor es menor o igual que valorMaximo
		if (valor >= valorMinimo && valor <= valorMaximo) {
			//Devuelve true
			return true;
		}
		return false;
	}
	
	public static boolean cumpleRangoChar(
			char valor, 
			char valorMinimo,
			char valorMaximo){
		//Si valor es mayor o igual que valorMinimo y valor es menor o igual que valorMaximo
		if (valor == valorMinimo || valor == valorMaximo) {
			//Devuelve true
			return true;
		}
		return false;
	}


	/** ***************************************************************************************
	 * NOMBRE: cumpleLongitudMin                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de al menos x caracteres, siendo
	 * 		x el entero pasado como par�metro
	 * 
	 * @param texto String texto a comprobar
	 * @param longitudMinima int que indique longitud m�nima.
	 * 
	 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
	 * FECHA: Enero 2023
	 * AUTOR: Helena Martinez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMin(String texto, int longitudMinima){
		//Si el string no es nulo y supera la longitud minima de caracteres devuelve true
		if (comprobarNulo(texto) && texto.length() >= longitudMinima) {
			return true;
		}
		return false;
	}


	/** ***************************************************************************************
	 * NOMBRE: cumpleLongitudMax                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de, como mucho, x caracteres, siendo
	 * 		x el entero pasado como par�metro
	 * 
	 * @param texto String con el texto a comprobar
	 * @param longitudMaxima int con la longitud m�xima del texto
	 * 
	 * @return true, si el texto es menor o igual que la longitud m�xima.
	 * FECHA: Enero 2023 
	 * AUTOR: Helena Martinez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima){
		//Si el string no es nulo y no supera la longitud maxima de caracteres devuelve true
		if (comprobarNulo(texto) && texto.length() <= longitudMaxima) {
			return true;
		}
		return false;
	}


	/** **************************************************************************************
	 * NOMBRE: cumpleLongitud                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que la longitud de un texto se encuentra entre unos valores m�ximos y m�nimos 
	 * 
	 * @param texto String con el texto que va a validar
	 * @param longitudMinima (int) M�nima longitud del texto
	 * @param longitudMaxima (int) M�xima longitud v�lida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima
	 *               <= longitudTexto <=longitudMaxima
	 * FECHA: Enero 2023 
	 * AUTOR: Helena Martinez Duro - Madrid
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima) {
		if (comprobarNulo(texto) && //Si el texto no es nulo
				cumpleRango(texto.length(), longitudMinima, longitudMaxima)) {//y la longitud está entre los valores recibidos
			//Devuelve true
			return true;
		}
		return false;
	}
	/**
	 * Valida una fecha calendar con m�nimo min
	 * @param fecha
	 * @param min
	 * @return
	 */
	public static boolean valDateMin(LocalDate fecha, LocalDate min){
		if ((comprobarNulo(fecha) && comprobarNulo(min)) && //Si ninguna fecha es nula
				min.compareTo(fecha) <= 0) { //Y la fecha no es anterior a la fecha minima
			return true;
		}
		return false;
	}
	
	/**
	 * Valida una fecha calendar con m�ximo max
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max){
		if ((comprobarNulo(fecha) && comprobarNulo(max)) && //Si ninguna fecha es nula
				max.compareTo(fecha) >= 0) { //Y la fecha no es posterior a la fecha maxima
			return true;
		}
		return false;
		
	}	
	
	/**
	 * esFechaValida
	 * Recibe una string con formato fecha dd/mm/aaaa y comprueba el formato
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaValida(String fecha){
		try {
			//Parsea la fecha. Si no da error devolvera true.
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate.parse(fecha, format);
			return true;
		} catch (DateTimeParseException dtpe) {}
		//Si da error devolvera false.
		return false;
	}
	
	/**
	 * esFechaActual
	 * Recibe un LocalDate y comprueba si coincide con la fecha actual.
	 * @param fecha LocalDate
	 * @return boolean
	 */
	public static boolean esFechaActual(LocalDate fecha){
		if (comprobarNulo(fecha) && LocalDate.now().compareTo(fecha) == 0) { //Y la fecha no es posterior a la fecha maxima
			return true;
		}
		return false;
	}
	
	/**
	 * Nombre esPasswordValida
	 * Descripcion Comprueba que la cadena recibida cumpla con lasnormas de contrase�a
	 * @param password string con la contrase�a introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password){
		/*Si password no es nulo y encaja con el patron de password devuelve true*/
		if (comprobarNulo(password) && password.matches(PASSWORD_PATTERN)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que comprueba que el string de producto contenga 5 caracteres, los dos primeros
	 * siendo letras mayusculas y el resto 3 digitos.
	 * @param producto String
	 * @return boolean
	 */
	public static boolean esProductoValido(String producto) {
		if (comprobarNulo(producto) && cumpleLongitud(producto, 5, 5) && 
				isAlfanumeric(producto) && producto.matches(PRODUCTO_PATTERN)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que comprueba si una string es nula y devuelve false o true segun si lo es o no
	 * @param str String
	 * @return boolean
	 */
	public static boolean comprobarNulo(String str) {
		if (str != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que comprueba si una LocalDate es nula y devuelve false o true segun si lo es o no
	 * @param ld LocalDate
	 * @return boolean
	 */
	public static boolean comprobarNulo(LocalDate ld) {
		if (ld != null) {
			return true;
		}
		return false;
	}
}
