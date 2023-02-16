package es.rf.tienda.dominio;

import java.time.LocalDate;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;

/**
 * Nombre		Usuario
 * Descripcion	Caracteristicas de un usuario
 * @author 		Helena Martinez
 * @version		5 de febrero de 2023
 */
public class Usuario {
	
	/**
	 * Id del usuario. Autoincremental.
	 */
	private int id_usuario;
	
	/**
	 * Nombre de usuario. Alfanumerico entre 5 y 100 caracteres. Requerido.
	 */
	private String user_nombre;
	
	/**
	 * Email del usuario. Alfanumerico entre 6 y 100 caracteres. Requerido.
	 */
	private String user_email;
	
	/**
	 * Contrasenia del usuario. Hidden. Entre 8 y 20 caracteres. Debe contener minimo 1 numero, 
	 * 1 letra y 1 carácter especial. Requerido.
	 */
	private String user_pass;
	
	/**
	 * Tipo de usuario. Valor numerico. Requerido.
	 */
	private int user_tipo;
	
	/**
	 * DNI del usuario. Alfanumerico de 12 caracteres. null por defecto. Opcional.
	 */
	private String user_dni;
	
	/**
	 * Fecha de alta del usuario. Null por defecto. Opcional.
	 */
	private LocalDate user_fecAlta;
	
	/**
	 * Fecha de confirmacion del usuario. Null por defecto. Opcional.
	 */
	private LocalDate user_fecConfirmacion;
	
	
	/**
	 * Constructor con todos los parametros
	 * @param id_usuario
	 * @param user_nombre
	 * @param user_email
	 * @param user_pass
	 * @param user_tipo
	 * @param user_dni
	 * @param user_fecAlta
	 * @param user_fecConfirmacion
	 * @throws DomainException
	 */
	public Usuario(int id_usuario, String user_nombre, String user_email, String user_pass, int user_tipo,
			String user_dni, LocalDate user_fecAlta, LocalDate user_fecConfirmacion) throws DomainException {
		setId_usuario(id_usuario);
		setUser_nombre(user_nombre);
		setUser_email(user_email);
		setUser_pass(user_pass);
		setUser_tipo(user_tipo);
		setUser_dni(user_dni);
		setUser_fecAlta(user_fecAlta);
		setUser_fecConfirmacion(user_fecConfirmacion);
	}
	
	/**
	 * Constructor con parametros requeridos
	 * @param id_usuario
	 * @param user_nombre
	 * @param user_email
	 * @param user_pass
	 * @param user_tipo
	 * @throws DomainException
	 */
	public Usuario(int id_usuario, String user_nombre, String user_email, String user_pass, 
			int user_tipo) throws DomainException {
		setId_usuario(id_usuario);
		setUser_nombre(user_nombre);
		setUser_email(user_email);
		setUser_pass(user_pass);
		setUser_tipo(user_tipo);
		setUser_dni(null);
		setUser_fecAlta(null);
		setUser_fecConfirmacion(null);
	}
	
	/**
	 * Constructor vacio
	 */
	public Usuario() {}

	/**
	 * Getter de id_usuario
	 * @return int
	 */
	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * Setter de id_usuario
	 * @param id_usuario int
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * Getter de user_nombre
	 * @return String
	 */
	public String getUser_nombre() {
		return user_nombre;
	}

	/**
	 * Setter de user_nombre
	 * @param user_nombre
	 * @throws DomainException si los requisitos no se cumplen
	 */
	public void setUser_nombre(String user_nombre) throws DomainException {
		if (Validator.cumpleLongitud(user_nombre, 5, 100)) {
			this.user_nombre = user_nombre;
		} else {
			throw new DomainException("El nombre del usuario debe ser alfanumerico"
					+ " y tener entre 5 y 100 caracteres.");
		}
	}

	/**
	 * Getter de email
	 * @return String
	 */
	public String getUser_email() {
		return user_email;
	}

	/**
	 * Setter de email
	 * @param user_email String
	 * @throws DomainException si no cumple los requisitos
	 */
	public void setUser_email(String user_email) throws DomainException {
		if (Validator.isEmailValido(user_email)) {
			this.user_email = user_email;
		} else {
			throw new DomainException("El email debe ser tener el siguiente "
					+ "formato: _ejemplo1@e_jemplo2.com o _ejemplo1@e_jemplo2.es");
		}
		
	}

	/**
	 * Getter de user_pass
	 * @return String
	 */
	public String getUser_pass() {
		return user_pass;
	}

	/**
	 * Setter de user_pass
	 * @param user_pass String
	 * @throws DomainException 
	 */
	public void setUser_pass(String user_pass) throws DomainException {
		if (Validator.cumpleLongitud(user_pass, 8, 20) &&
				Validator.esPasswordValida(user_pass)) {
			this.user_pass = user_pass;
		} else {
			throw new DomainException("La contraseña debe tener entre 8 y 20"
					+ "caracteres y debe contener almenos un caracter");
		}
		
	}

	/**
	 * Getter de user_tipo
	 * @return int
	 */
	public int getUser_tipo() {
		return user_tipo;
	}

	/**
	 * Setter de user_tipo
	 * @param user_tipo int
	 */
	public void setUser_tipo(int user_tipo) {
		//Requiere tabla de tipos
		this.user_tipo = user_tipo;
	}

	/**
	 * Getter de user_dni
	 * @return String
	 */
	public String getUser_dni() {
		return user_dni;
	}

	/**
	 * Setter de user_dni
	 * @param user_dni String
	 * @throws DomainException si no cumple los requisitos
	 */
	public void setUser_dni(String user_dni) throws DomainException {
		if (Validator.cumpleDNI(user_dni)) {
			this.user_dni = user_dni;
		} else if (user_dni == null){
			this.user_dni = null;
		} else {
			throw new DomainException("El DNI debe tener 12 caracteres en formato "
					+ "XX.XXX.XXX-X");
		}
	}

	/**
	 * Getter de user_fecAlta
	 * @return LocalDate
	 */
	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}

	/**
	 * Setter de user_fecAlta
	 * @param user_fecAlta LocalDate
	 * @throws DomainException 
	 */
	public void setUser_fecAlta(LocalDate user_fecAlta) throws DomainException {
		if (user_fecAlta == null) {
			this.user_fecAlta = null;
		} else if (Validator.esFechaActual(user_fecAlta)){
			this.user_fecAlta = user_fecAlta;
		} else {
			throw new DomainException("La fecha de alta debe ser la fecha actual en el momento del alta!");
		}
	}
	

	/**
	 * Getter de user_fecConfirmacion
	 * @return LocalDate
	 */
	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	/**
	 * Setter de user_fecConfirmacion
	 * @param user_fecConfirmacion LocalDate
	 * @throws DomainException 
	 */
	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) throws DomainException {
		if (user_fecConfirmacion == null) {
			this.user_fecConfirmacion = null;
		} else if (Validator.esFechaActual(user_fecConfirmacion)){
			this.user_fecConfirmacion = user_fecConfirmacion;
		} else {
			throw new DomainException("La fecha de confirmacion debe ser la fecha actual en el momento "
					+ "de la confirmacion!");
		}
	}
}
