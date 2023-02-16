package es.rf.tienda.dominio;


/**
 * Nombre		Direccion
 * Descripcion	Caracteristicas de una direccion
 * @author 		Helena Martinez
 * @version		10 de febrero de 2023
 */
public class Direccion {

	/**
	 * Nombre de la direccion
	 */
	private String dir_nombre;
	
	/**
	 * Direccion
	 */
	private String dir_direccion;
	
	/**
	 * Poblacion de la direccion
	 */
	private String dir_poblacion;
	
	/**
	 * Codigo postal de la direccion
	 */
	private String dir_cPostal;
	
	/**
	 * Provincia de la direccion
	 */
	private String dir_provincia;
	
	/**
	 * Pais de la direccion
	 */
	private String dir_pais;
	
	/**
	 * Correo electronico
	 */
	private String dir_correoE;

	/**
	 * Cosntructor vacio
	 */
	public Direccion() {}
	
	/**
	 * Constructor con parametros
	 * @param dir_nombre
	 * @param dir_direccion
	 * @param dir_poblacion
	 * @param dir_cPostal
	 * @param dir_provincia
	 * @param dir_pais
	 * @param dir_correoE
	 */
	public Direccion(String dir_nombre, String dir_direccion, String dir_poblacion, String dir_cPostal,
			String dir_provincia, String dir_pais, String dir_correoE) {
		setDir_nombre(dir_nombre);
		setDir_direccion(dir_direccion);
		setDir_poblacion(dir_poblacion);
		setDir_cPostal(dir_cPostal);
		setDir_provincia(dir_provincia);
		setDir_pais(dir_pais);
		setDir_correoE(dir_correoE);
	}

	/**
	 * Getter de dir_nombre
	 * @return String
	 */
	public String getDir_nombre() {
		return dir_nombre;
	}

	/**
	 * Setter de dir_nombre
	 * @param dir_nombre String
	 */
	public void setDir_nombre(String dir_nombre) {
		if (dir_nombre != null && dir_nombre.length() > 100) {
			this.dir_nombre = dir_nombre.substring(0, 99);
		} else {
			this.dir_nombre = dir_nombre;
		}
	}

	/**
	 * Getter de dir_direccion
	 * @return String
	 */
	public String getDir_direccion() {
		return dir_direccion;
	}

	/**
	 * Setter de dir_direccion
	 * @param dir_direccion String
	 */
	public void setDir_direccion(String dir_direccion) {
		this.dir_direccion = dir_direccion;
	}

	/**
	 * Getter de dir_poblacion
	 * @return String
	 */
	public String getDir_poblacion() {
		return dir_poblacion;
	}

	/**
	 * Setter de dir_poblacion
	 * @param dir_poblacion String
	 */
	public void setDir_poblacion(String dir_poblacion) {
		this.dir_poblacion = dir_poblacion;
	}

	/**
	 * Getter de dir_cPostal
	 * @return String
	 */
	public String getDir_cPostal() {
		return dir_cPostal;
	}

	/**
	 * Setter de dir_cPostal
	 * @param dir_cPostal String
	 */
	public void setDir_cPostal(String dir_cPostal) {
		this.dir_cPostal = dir_cPostal;
	}

	/**
	 * Getter de dir_provincia
	 * @return String
	 */
	public String getDir_provincia() {
		return dir_provincia;
	}

	/**
	 * Setter de dir_provincia
	 * @param dir_provincia String
	 */
	public void setDir_provincia(String dir_provincia) {
		this.dir_provincia = dir_provincia;
	}

	/**
	 * Getter de dir_pais
	 * @return String
	 */
	public String getDir_pais() {
		return dir_pais;
	}

	/**
	 * Setter de dir_pais
	 * @param dir_pais String
	 */
	public void setDir_pais(String dir_pais) {
		this.dir_pais = dir_pais;
	}

	/**
	 * Getter de dir_correoE
	 * @return String
	 */
	public String getDir_correoE() {
		return dir_correoE;
	}

	/**
	 * Setter de dir_correoE
	 * @param dir_correoE String
	 */
	public void setDir_correoE(String dir_correoE) {
		this.dir_correoE = dir_correoE;
	}
}
