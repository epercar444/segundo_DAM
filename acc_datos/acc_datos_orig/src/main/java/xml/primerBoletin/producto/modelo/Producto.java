package xml.primerBoletin.producto.modelo;

public class Producto {
	private int id,stock;
	private String nombre;
	private float precio;
	private boolean aLaVenta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean getaLaVenta() {
		return aLaVenta;
	}
	public void setaLaVenta(boolean aLaVenta) {
		this.aLaVenta = aLaVenta;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", stock=" + stock + ", nombre=" + nombre + ", precio=" + precio + ", aLaVenta="
				+ aLaVenta + "]";
	}
	public Producto(int id, int stock, String nombre, float precio, boolean aLaVenta) {
		super();
		this.id = id;
		this.stock = stock;
		this.nombre = nombre;
		this.precio = precio;
		this.aLaVenta = aLaVenta;
	}
	public Producto() {
		super();
	}
	
	
}
