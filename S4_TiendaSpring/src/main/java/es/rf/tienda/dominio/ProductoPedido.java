package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;

/**
 * Nombre: ProductoPedido
 * Clase que contiene los datos de cada producto dentro de un pedido
 * @author helena.martinez.duro
 * @version	10 de febrero de 2023
 */
//Esta clase no sera Entity
public class ProductoPedido {
	
	/**
	 * Id del producto del carrito. Requerido.
	 */
	private String id_producto;
	
	/**
	 * Cantidad de productos en el carrito. Mayor que 0.
	 */
	private int car_cantidad;
	
	/**
	 * Precio de una unidad de producto.
	 */
	private double car_precio;
	
	/**
	 * Constructor principal
	 * @param id_producto String
	 * @param car_cantidad int
	 * @param car_precio double
	 * @throws DomainException Si algun parametro no cumple requisitos.
	 */
	public ProductoPedido(String id_producto, int car_cantidad, double car_precio) throws DomainException {
		setId_producto(id_producto);
		setCar_cantidad(car_cantidad);
		setCar_precio(car_precio);
	}

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
	 * @throws DomainException si no cumple los requisitos
	 */
	public void setId_producto(String id_producto) throws DomainException {
		if (id_producto != null) {
			this.id_producto = id_producto;
		} else {
			throw new DomainException("La id del producto no puede estar vacia!");
		}
	}
	
	/**
	 * Getter de car_cantidad
	 * @return int
	 */
	public int getCar_cantidad() {
		return car_cantidad;
	}
	
	/**
	 * Setter de car_cantidad
	 * @param car_cantidad int
	 * @throws DomainException si es 0 o menor.
	 */
	public void setCar_cantidad(int car_cantidad) throws DomainException {
		if (car_cantidad > 0) {
			this.car_cantidad = car_cantidad;
		} else {
			throw new DomainException("La cantidad no puede ser 0!");
		}
		
	}
	
	/**
	 * Getter de car_precio
	 * @return double
	 */
	public double getCar_precio() {
		return car_precio;
	}
	
	/**
	 * Setter de car_precio
	 * @param car_precio double
	 */
	public void setCar_precio(double car_precio) {
		this.car_precio = car_precio;
	}
	
}
