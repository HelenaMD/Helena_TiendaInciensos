package es.rf.tienda.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * Nombre: TipoUsuario
 * Descripcion: Clase que contiene los tipos de usuario
 * @author Helena Martinez Duro
 * @version 10 de febrero de 2023
 */
//@Entity
public class TipoUsuario {
	
	/**
	 * Tipo de usuario
	 */
	//@Id
	//@OneToMany
	private int tipo_usuario;
	
	/**
	 * Rol que desempenia el usuario
	 */
	private String rol_usuario;

	
	/**
	 * Constructor principal
	 * @param tipo_usuario
	 * @param rol_usuario
	 */
	public TipoUsuario(int tipo_usuario, String rol_usuario) {
		setTipo_usuario(tipo_usuario);
		setRol_usuario(rol_usuario);
	}
	
	/**
	 * Constructor vacio
	 */
	public TipoUsuario() {}

	/**
	 * Getter de tipo_usuario
	 * @return int
	 */
	public int getTipo_usuario() {
		return tipo_usuario;
	}

	/**
	 * Setter de tipo_usuario
	 * @param tipo_usuario int
	 */
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	/**
	 * Getter de rol_usuario
	 * @return String
	 */
	public String getRol_usuario() {
		return rol_usuario;
	}

	/**
	 * Setter de rol_usuario
	 * @param rol_usuario String
	 */
	public void setRol_usuario(String rol_usuario) {
		this.rol_usuario = rol_usuario;
	}
	
}
