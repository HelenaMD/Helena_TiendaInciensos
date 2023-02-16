package es.rf.tienda.dominio;

import java.text.DecimalFormat;
import java.time.LocalDate;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;

/**
 * 
 * Nombre		Producto
 * Descripcion	Caracteristicas de un producto
 * @author 		Helena Martinez
 * @version		2 de febrero de 2023
 *
 */
public class Producto {
	
	/**
	 * Codigo del producto. Debe ser alfanumerico de 5 caracteres. Requerido.
	 */
	private String id_producto;
	
	/**
	 * Descrpcion del producto. Debe ser alfanumerico de entre 5 y 100 caracteres. Requerido.
	 */
	private String pro_descripcion;
	
	/**
	 * Explicacion mas a fondo del producto. Alfanumerico de entre 5 y 2000 caracteres. null por defecto. 
	 * Opcional.
	 */
	private String pro_desLarga;
	
	/**
	 * Precio del producto. Double con dos decimales. Entre 0 y 100. Requerido.
	 */
	private double pro_precio;
	
	/**
	 * Stock del producto. Opcional.
	 */
	private int pro_stock;
	
	/**
	 * Fecha en la que esta prevista que se reponga el producto. Debe ser fecha futura a la actual. 
	 * null por defecto. Opcional.
	 */
	private LocalDate pro_fecRepos;
	
	/**
	 * Fecha en la que se activa el producto. Debe ser fecha futura a la actual. null por defecto Opcional.
	 */
	private LocalDate pro_fecActi;
	
	/**
	 * Fecha en la que se activa el producto. Debe ser fecha futura a la actual y a la de activacion (si tiene).
	 * null por defecto. Opcional.
	 */
	private LocalDate pro_fecDesacti;
	
	/**
	 * Unidad de venta del producto. Debe ser alfanumerico de entre 1 y 10 caracteres. Requerido.
	 */
	private String pro_uniVenta;
	
	/**
	 * Ultimas unidades en stock del producto. Double con 2 decimales. 0 por defecto. Opcional.
	 */
	private double pro_cantXUniVenta;
	
	/**
	 * Ultima unidad del producto. null por defecto. Opcional.
	 */
	private String pro_uniUltNivel;
	
	/**
	 * Codigo numerico del pais de prodecendia del producto. Hace referencia al pais de la lista de paises.
	 * Requerido.
	 */
	private int id_pais;
	
	/**
	 * Explicacion del uso recomendado del producto. Alfanumerico de entre 0 a 2000 caracteres. 
	 * null por defecto. Opcional.
	 */
	private String pro_usoRecomendado;
	
	/**
	 * Codigo numerico de la categoria del producto. Hace referencia a la categoria de la lista de categorias.
	 * Requerido.
	 */
	private int id_categoria;
	
	/**
	 * Cantidad de stock reservado del producto. 0 por defecto. Opcional.
	 */
	private int pro_stkReservado;
	
	/**
	 * Cantidad de stock reservado del producto para el nivel alto. 0 por defecto. Opcional.
	 */
	private int pro_nStkAlto;
	
	/**
	 * Cantidad de stock reservado del producto para el nivel bajo. 0 por defecto. Opcional.
	 */
	private int pro_nStkBajo;
	
	/**
	 * Caracter unico que muestra el estado del producto. "A" por defecto. Opcional.
	 */
	private char pro_stat;
	
	/**
	 * Constructor principal
	 * @param id_producto
	 * @param pro_descripcion
	 * @param pro_desLarga
	 * @param pro_precio
	 * @param pro_stock
	 * @param pro_fecRepos
	 * @param pro_fecActi
	 * @param pro_fecDesacti
	 * @param pro_uniVenta
	 * @param pro_cantXUniVenta
	 * @param pro_uniUltNivel
	 * @param id_pais
	 * @param pro_usoRecomendado
	 * @param id_categoria
	 * @param pro_stkReservado
	 * @param pro_nStkAlto
	 * @param pro_nStkBajo
	 * @param pro_stat
	 * @throws DomainException 
	 */
	public Producto(String id_producto, String pro_descripcion, String pro_desLarga, double pro_precio, int pro_stock,
			LocalDate pro_fecRepos, LocalDate pro_fecActi, LocalDate pro_fecDesacti, String pro_uniVenta,
			double pro_cantXUniVenta, String pro_uniUltNivel, int id_pais, String pro_usoRecomendado, int id_categoria,
			int pro_stkReservado, int pro_nStkAlto, int pro_nStkBajo, char pro_stat) throws DomainException {
		setId_producto(id_producto);
		setPro_descripcion(pro_descripcion);
		setPro_desLarga(pro_desLarga);
		setPro_precio(pro_precio);
		setPro_stock(pro_stock);
		setPro_fecRepos(pro_fecRepos);
		setPro_fecActi(pro_fecActi);
		setPro_fecDesacti(pro_fecDesacti);
		setPro_uniVenta(pro_uniVenta);
		setPro_cantXUniVenta(pro_cantXUniVenta);
		setPro_uniUltNivel(pro_uniUltNivel);
		setId_pais(id_pais);
		setPro_usoRecomendado(pro_usoRecomendado);
		setId_categoria(id_categoria);
		setPro_stkReservado(pro_stkReservado);
		setPro_nStkAlto(pro_nStkAlto);
		setPro_nStkBajo(pro_nStkBajo);
		setPro_stat(pro_stat);
	}
	
	/**
	 * Constructor secundario
	 * @param id_producto
	 * @param pro_descripcion
	 * @param pro_precio
	 * @param pro_uniVenta
	 * @param id_pais
	 * @param id_categoria
	 * @throws DomainException 
	 */
	public Producto(String id_producto, String pro_descripcion, double pro_precio, String pro_uniVenta, 
			int id_pais, int id_categoria) throws DomainException {
		setId_producto(id_producto);
		setPro_descripcion(pro_descripcion);
		setPro_desLarga(null);
		setPro_precio(pro_precio);
		setPro_stock(0);
		setPro_fecRepos(null);
		setPro_fecActi(null);
		setPro_fecDesacti(null);
		setPro_uniVenta(pro_uniVenta);
		setPro_cantXUniVenta(0);
		setPro_uniUltNivel(null);
		setId_pais(id_pais);
		setPro_usoRecomendado(null);
		setId_categoria(id_categoria);
		setPro_stkReservado(0);
		setPro_nStkAlto(0);
		setPro_nStkBajo(0);
		setPro_stat('A');
	}
	
	/**
	 * Constructor vacio
	 */
	public Producto() {}

	/**
	 * Getter de id_producto 
	 * @return String
	 */
	public String getId_producto() {
		return id_producto;
	}
	
	/**
	 * Setter de id_producto 
	 * @param id_producto String
	 * @throws DomainException si no cumple con los requisitos
	 */
	public void setId_producto(String cod_producto) throws DomainException {
		if (Validator.isAlfanumeric(cod_producto) && Validator.cumpleLongitud(cod_producto, 5, 5)) {
			this.id_producto = cod_producto;
		} else {
			throw new DomainException("El codigo de producto debe ser alfanumerico de 5 caracteres.");
		}
	}
	
	/**
	 * Getter de pro_descripcion
	 * @return String
	 */
	public String getPro_descripcion() {
		return pro_descripcion;
	}
	
	/**
	 * Setter de pro_descripcion
	 * @param pro_descripcion String
	 * @throws DomainException si no cumple con los requisitos
	 */
	public void setPro_descripcion(String descripcion_producto) throws DomainException {
		if (Validator.cumpleLongitud(descripcion_producto, 5, 100)) {
			this.pro_descripcion = descripcion_producto;
		} else {
			throw new DomainException("La descripcion del producto debe ser alfanumerico de entre 5 y "
					+ "100 caracteres.");
		}
	}
	
	/**
	 * Getter de pro_desLarga
	 * @return String
	 */
	public String getPro_desLarga() {
		return pro_desLarga;
	}
	
	/**
	 * Setter de pro_desLarga
	 * @param pro_desLarga String
	 * @throws DomainException Si no cumple con los requisitos.
	 */
	public void setPro_desLarga(String explicacion_producto) throws DomainException {
		if (Validator.cumpleLongitud(explicacion_producto, 5, 2000)) {
			this.pro_desLarga = explicacion_producto;
		} else if (explicacion_producto == null || explicacion_producto.length() == 0) {
			this.pro_desLarga = null;
		} else {
			throw new DomainException("La explicacion del producto debe ser alfanumerico de entre 5 y "
					+ "2000 caracteres.");
		}
	}
	
	/**
	 * Getter de pro_precio.
	 * @return String decimal formatted to ###.00.
	 */
	public String getPro_precio() {
		return new DecimalFormat("###.00").format(this.pro_precio);
	}
	
	/**
	 * Setter de pro_precio.
	 * @param pro_precio double
	 */
	public void setPro_precio(double precio_producto) {
		if (Validator.cumpleRango(precio_producto, 0, 100)) {
			this.pro_precio = precio_producto;
		}
	}
	
	/**
	 * Getter de pro_stock
	 * @return int
	 */
	public int getPro_stock() {
		return pro_stock;
	}
	
	/**
	 * Setter de pro_stock
	 * @param pro_stock int
	 */
	public void setPro_stock(int stock_producto) {
		this.pro_stock = stock_producto;
	}
	
	/**
	 * Getter de pro_fecRepos
	 * @return LocalDate
	 */
	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}
	
	/**
	 * Setter de pro_fecRepos
	 * @param pro_fecRepos
	 * @throws DomainException Si la fecha es anterior a la actual.
	 */
	public void setPro_fecRepos(LocalDate fechaPrevistaRepo_producto) throws DomainException {
		if (fechaPrevistaRepo_producto == null) {
			this.pro_fecRepos = null;
		} else if (Validator.valDateMin(fechaPrevistaRepo_producto, LocalDate.now())) {
			this.pro_fecRepos = LocalDate.of(fechaPrevistaRepo_producto.getYear(), 
					fechaPrevistaRepo_producto.getMonthValue(), 
					fechaPrevistaRepo_producto.getDayOfMonth());
		} else {
			throw new DomainException("La fecha de reposicion prevista debe ser una fecha futura a la actual.");
		}
		
	}
	
	/**
	 * Getter de pro_fecActi
	 * @return LocalDate
	 */
	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}
	
	/**
	 * Setter de pro_fecActi
	 * @param pro_fecActi LocalDate
	 * @throws DomainException Si la fecha es anterior a la actual.
	 */
	public void setPro_fecActi(LocalDate fechaActivacion_producto) throws DomainException {
		if (fechaActivacion_producto == null) {
			this.pro_fecActi = null;
		} else if (Validator.valDateMin(fechaActivacion_producto, LocalDate.now())) {
			this.pro_fecActi = LocalDate.of(fechaActivacion_producto.getYear(), 
					fechaActivacion_producto.getMonthValue(), 
					fechaActivacion_producto.getDayOfMonth());
		} else {
			throw new DomainException("La fecha de activacion prevista debe ser una fecha futura a la actual.");
		}
	}
	
	/**
	 * Getter de pro_fecDesacti
	 * @return LocalDate
	 */
	public LocalDate getPro_fecDesacti() {
		return pro_fecDesacti;
	}
	
	/**
	 * Setter de pro_fecDesacti
	 * @param pro_fecDesacti LocalDate
	 * @throws DomainException 
	 */
	public void setPro_fecDesacti(LocalDate fechaDesactivacion_producto) throws DomainException {
		if (fechaDesactivacion_producto == null) {
			this.pro_fecDesacti = null;
		} else if ((getPro_fecActi() != null 
				&& Validator.valDateMin(fechaDesactivacion_producto, getPro_fecActi()))
				|| Validator.valDateMin(fechaDesactivacion_producto, LocalDate.now())) {
			this.pro_fecDesacti = fechaDesactivacion_producto;
		} else {
			throw new DomainException("La fecha de desactivacion prevista debe ser una fecha futura a la actual"
					+ " o a la de activacion.");
		}
	}
	
	/**
	 * Getter de pro_uniVenta
	 * @return String
	 */
	public String getPro_uniVenta() {
		return pro_uniVenta;
	}
	
	/**
	 * Setter de pro_uniVenta
	 * @param pro_uniVenta String
	 * @throws DomainException si no cumple los requisitos
	 */
	public void setPro_uniVenta(String unidadVenta_producto) throws DomainException {
		if (Validator.cumpleLongitud(unidadVenta_producto, 1, 10)) {
			this.pro_uniVenta = unidadVenta_producto;
		} else {
			throw new DomainException("La unidad de venta del producto debe ser alfanumerico de entre 1 y "
					+ "10 caracteres.");
		}
	}
	
	/**
	 * Getter de pro_cantXUniVenta
	 * @return String con la cantidad formateada a ###.00.
	 */
	public String getPro_cantXUniVenta() {
		return new DecimalFormat("###.00").format(this.pro_cantXUniVenta);
	}
	
	/**
	 * Setter de pro_cantXUniVenta
	 * @param pro_cantXUniVenta double
	 */
	public void setPro_cantXUniVenta(double cantidadUnidadesUltimas_producto) {
		this.pro_cantXUniVenta = cantidadUnidadesUltimas_producto;
	}
	
	/**
	 * Getter de pro_uniUltNivel
	 * @return String
	 */
	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}
	
	/**
	 * Setter de pro_uniUltNivel
	 * @param pro_uniUltNivel String
	 * @throws DomainException si no cumple con los requisitos.
	 */
	public void setPro_uniUltNivel(String unidadUltima_producto) throws DomainException {
		if (unidadUltima_producto == null || unidadUltima_producto.length() == 0) {
			unidadUltima_producto = null;
		} else {
			this.pro_uniUltNivel = unidadUltima_producto;
		}
	}
	
	/**
	 * Getter de paisDeOrigen_producto
	 * @return int
	 */
	public int getId_pais() {
		return id_pais;
	}
	
	/**
	 * Setter de id_pais
	 * @param id_pais int
	 */
	public void setId_pais(int paisDeOrigen_producto) {
		//Check por implementar, necesaria lista de paises.
		this.id_pais = paisDeOrigen_producto;
	}
	
	/**
	 * Getter de pro_usoRecomendado
	 * @return String
	 */
	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}
	
	/**
	 * Setter de pro_usoRecomendado
	 * @param pro_usoRecomendado String
	 * @throws DomainException 
	 */
	public void setPro_usoRecomendado(String usoRecomendado_producto) throws DomainException {
		if (usoRecomendado_producto == null) {
			usoRecomendado_producto = null;
		} else {
			if (usoRecomendado_producto.length() > 2000) {
				this.pro_usoRecomendado = usoRecomendado_producto.substring(0, 1999);
			} else {
				this.pro_usoRecomendado = usoRecomendado_producto;
			}
		}
	}
	
	/**
	 * Getter de id_categoria
	 * @return int
	 */
	public int getId_categoria() {
		return id_categoria;
	}
	
	/**
	 * Setter de id_categoria
	 * @param id_categoria int
	 */
	public void setId_categoria(int categoria_producto) {
		//Check por implementar, necesaria lista de categorias
		this.id_categoria = categoria_producto;
	}
	
	/**
	 * Getter de pro_stkReservado
	 * @return int
	 */
	public int getPro_stkReservado() {
		return pro_stkReservado;
	}
	
	/**
	 * Setter de pro_stkReservado
	 * @param pro_stkReservado int
	 */
	public void setPro_stkReservado(int stockReservado_producto) {
		this.pro_stkReservado = stockReservado_producto;
	}
	
	/**
	 * Getter de pro_nStkAlto
	 * @return int
	 */
	public int getPro_nStkAltoo() {
		return pro_nStkAlto;
	}
	
	/**
	 * Setter de pro_nStkAlto
	 * @param pro_nStkAlto int
	 */
	public void setPro_nStkAlto(int stockReservadoNivAlto_producto) {
		this.pro_nStkAlto = stockReservadoNivAlto_producto;
	}
	
	/**
	 * Getter de pro_nStkBajo
	 * @return int
	 */
	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}
	
	/**
	 * Setter de pro_nStkBajo
	 * @param pro_nStkBajo int
	 */
	public void setPro_nStkBajo(int stockReservadoNivBajo_producto) {
		this.pro_nStkBajo = stockReservadoNivBajo_producto;
	}
	
	/**
	 * Getter de pro_stat
	 * @return char
	 */
	public char getPro_stat() {
		return pro_stat;
	}
	
	/**
	 * Setter de pro_stat
	 * @param estado_producto char
	 * @throws DomainException si no se cumplen los requisitos
	 */
	public void setPro_stat(char estado_producto) throws DomainException {
		if (Validator.cumpleRangoChar(estado_producto, 'A', 'B')) {
			this.pro_stat = estado_producto;
		} else {
			throw new DomainException("El estado debe ser un caracter entre \'A\' o \'B\'");
		}
	}
	
}
