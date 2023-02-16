package es.rf.tienda.dominio;

import es.rf.tienda.util.ErrorMessages;
import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * 
 * Nombre		Categoria
 * Descripcion	Lista de categorías
 * @author 		Helena Martinez
 * @version		2 de febrero de 2023
 *
 */

@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable, Modelo {
	
	//Si es autonumerico como pone en el excel tiene que ser static para poder
	// hacerlo autoincremental
	/**
	 * Id de la categoria. Autoincremental.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_categoria;
	
	/**
	 * Nombre de la categoria. Alfanumerico entre 5 y 50 caracteres. Requerido.
	 */
	@Column(nullable = false)
	private String cat_nombre;
	
	/**
	 * Descripcion de la categoria. Alfanumerico hasta 200 caracteres. Opcional.
	 */
	private String cat_descripcion;
	
	/**
	 * Constructor principal
	 * @param id_categoria
	 * @param catNombre
	 * @param catDescripcion
	 * @throws DomainException
	 */
	public Categoria(int id_categoria, String catNombre, String catDescripcion) throws DomainException {
		setId_categoria(id_categoria);
		setCat_nombre(catNombre);
		setCat_descripcion(catDescripcion);
	}
	
	/**
	 * Segundo constructor
	 * @param id_categoria
	 * @param catNombre
	 * @throws DomainException
	 */
	public Categoria(int id_categoria, String catNombre) throws DomainException {
		setId_categoria(id_categoria);
		setCat_nombre(catNombre);
		setCat_descripcion(null);
	}
	
	/**
	 * Constructor vacio
	 * @param catNombre
	 * @throws DomainException
	 */
	public Categoria() {}
	
	@Transient
	@JsonIgnore
	public boolean isValidInsert(){
		if (!Validator.isVacio(cat_nombre)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Transient
	@JsonIgnore
	public boolean isValidUpdate(){
		if (!Validator.isVacio(cat_nombre) && id_categoria > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Getter para identificador de categoria
	 * @return Integer con el id de la categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}
	
	/**
	 * Setter para identificador de categoria
	 * @param id_categoria int
	 */
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	/**
	 * Getter para el nombre de categoria
	 * @return cadena con el nombre de la categoria
	 */
	public String getCat_nombre() {
		return cat_nombre;
	}
	
	/**
	 * Setter para el nombre de categoria
	 * @throws DomainException 
	 * 
	 */
	public void setCat_nombre(String cat_nombre) throws DomainException {
		if (Validator.cumpleLongitud(cat_nombre, 5, 50)) {
			this.cat_nombre = cat_nombre;
		} else {
			throw new DomainException(ErrorMessages.CAT_NOMBRE_LONGITUD);
		}
	}
	
	/**
	 * Getter para la descripcion de categoria
	 * @return cadena con la descripcion de la categoria
	 */
	public String getCat_descripcion() {
		return cat_descripcion;
	}
	
	/**
	 * setter para la descripcion de categoria
	 * @throws DomainException si no cumple con los requisitos
	 * 
	 */
	public void setCat_descripcion(String cat_descripcion) {
		if (cat_descripcion != null) {
			if (cat_descripcion.length() > 200) {
				this.cat_descripcion = cat_descripcion.substring(0, 200);
			} else {
				this.cat_descripcion = cat_descripcion;
			}
		} else if (cat_descripcion == null) {
			this.cat_descripcion = null;
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		result = prime * result + id_categoria;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null)
				return false;
		} else if (!cat_descripcion.equals(other.cat_descripcion))
			return false;
		if (cat_nombre == null) {
			if (other.cat_nombre != null)
				return false;
		} else if (!cat_nombre.equals(other.cat_nombre))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_descripcion="
				+ cat_descripcion + "]";
	}
	
	
}
