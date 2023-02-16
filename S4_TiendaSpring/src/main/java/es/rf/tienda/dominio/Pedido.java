package es.rf.tienda.dominio;

import java.time.LocalDate;
import java.util.Set;

/**
 * Nombre		Pedido
 * Descripcion	Caracteristicas de un pedido
 * @author 		Helena Martinez
 * @version		10 de febrero de 2023
 */
public class Pedido {

	/**
	 * Identificador de pedido. Requerido
	 */
	private int id_pedido;
	
	/**
	 * Identificador cliente. Requerido
	 */
	private int id_usuario;
	
	/**
	 * Productos en el carrito.
	 */
	private Set<ProductoPedido> car_productos;
	
	/**
	 * Datos de la direccion de envio
	 */
	private Direccion car_envio;
	
	/**
	 * Datos de la direccion de facturacion
	 */
	private Direccion car_pago;
	
	/**
	 * Tarjeta con la que pagara el usuario
	 */
	private String car_tarjeta;
	
	/**
	 * Fecha caducidad de la tarjeta
	 */
	private LocalDate car_feCadud;
	
	/**
	 * CCV de la tarjeta
	 */
	private int car_ccv;
	
	/**
	 * Nombre del titular de la tarjeta
	 */
	private String car_nombre;
	
	/**
	 * Estado del carro. Referencia a tabla
	 */
	private int car_stat;
	
	/**
	 * Listado de fechas en las que se modifico el pedido.
	 */
	private String[] car_feCambio;

	
	public Pedido(int id_pedido, int id_usuario, Set<ProductoPedido> car_productos, Direccion car_envio,
			Direccion car_pago, String car_tarjeta, LocalDate car_feCadud, int car_ccv, String car_nombre, int car_stat,
			String[] car_feCambio) {
		this.id_pedido = id_pedido;
		this.id_usuario = id_usuario;
		this.car_productos = car_productos;
		this.car_envio = car_envio;
		this.car_pago = car_pago;
		this.car_tarjeta = car_tarjeta;
		this.car_feCadud = car_feCadud;
		this.car_ccv = car_ccv;
		this.car_nombre = car_nombre;
		this.car_stat = car_stat;
		this.car_feCambio = car_feCambio;
	}
	
	public Pedido() {}

	/**
	 * Getter de id_pedido
	 * @return int
	 */
	public int getId_pedido() {
		return id_pedido;
	}

	/**
	 * Setter de id_pedido
	 * @param id_pedido int
	 */
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	
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
	 * Getter de car_productos
	 * @return Set<ProductoPedido>
	 */
	public Set<ProductoPedido> getCar_productos() {
		return car_productos;
	}

	/**
	 * Setter de car_productos
	 * @param car_productos Set<ProductoPedido>
	 */
	public void setCar_productos(Set<ProductoPedido> car_productos) {
		this.car_productos = car_productos;
	}

	/**
	 * Getter de car_envio
	 * @return Direccion
	 */
	public Direccion getCar_envio() {
		return car_envio;
	}

	/**
	 * Setter de car_envio
	 * @param car_envio Direccion
	 */
	public void setCar_envio(Direccion car_envio) {
		this.car_envio = car_envio;
	}

	/**
	 * Getter de car_pago
	 * @return Direccion
	 */
	public Direccion getCar_pago() {
		return car_pago;
	}

	/**
	 * Setter de car_pago
	 * @param car_pago Direccion
	 */
	public void setCar_pago(Direccion car_pago) {
		this.car_pago = car_pago;
	}

	/**
	 * Getter de car_tarjeta
	 * @return String
	 */
	public String getCar_tarjeta() {
		return car_tarjeta;
	}

	/**
	 * Setter de car_tarjeta
	 * @param car_tarjeta String
	 */
	public void setCar_tarjeta(String car_tarjeta) {
		this.car_tarjeta = car_tarjeta;
	}

	/**
	 * Getter de car_feCadud
	 * @return LocalDate
	 */
	public LocalDate getCar_feCadud() {
		return car_feCadud;
	}

	/**
	 * Setter car_feCadud
	 * @param car_feCadud LocalDate
	 */
	public void setCar_feCadud(LocalDate car_feCadud) {
		this.car_feCadud = car_feCadud;
	}

	/**
	 * Getter car_ccv
	 * @return int
	 */
	public int getCar_ccv() {
		return car_ccv;
	}

	/**
	 * Setter car_ccv
	 * @param car_ccv int
	 */
	public void setCar_ccv(int car_ccv) {
		this.car_ccv = car_ccv;
	}

	/**
	 * Getter car_nombre
	 * @return String
	 */
	public String getCar_nombre() {
		return car_nombre;
	}

	/**
	 * Setter car_nombre
	 * @param car_nombre String
	 */
	public void setCar_nombre(String car_nombre) {
		this.car_nombre = car_nombre;
	}

	/**
	 * Getter de car_stat
	 * @return int
	 */
	public int getCar_stat() {
		return car_stat;
	}

	/**
	 * Setter de car_stat
	 * @param car_stat int
	 */
	public void setCar_stat(int car_stat) {
		this.car_stat = car_stat;
	}

	/**
	 * Getter de car_feCambio
	 * @return String[]
	 */
	public String[] getCar_feCambio() {
		return car_feCambio;
	}

	/**
	 * Setter de car_cambio
	 * @param car_feCambio String[]
	 */
	public void setCar_feCambio(String[] car_feCambio) {
		this.car_feCambio = car_feCambio;
	}
	
	
}
