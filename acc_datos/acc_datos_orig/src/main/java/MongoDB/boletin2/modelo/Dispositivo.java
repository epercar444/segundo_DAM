package MongoDB.boletin2.modelo;

import java.util.List;
import java.util.Objects;

public class Dispositivo {
	private int id,stock;
	private double precio;
	private String nombre,categoria;
	private List<Valoracion> valoraciones;
	private Especificacion especificaciones;
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}
	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}
	public Especificacion getEspecificaciones() {
		return especificaciones;
	}
	public void setEspecificaciones(Especificacion especificaciones) {
		this.especificaciones = especificaciones;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dispositivo other = (Dispositivo) obj;
		return id == other.id;
	}
	public Dispositivo(int id, int stock, double precio, String nombre, String categoria, List<Valoracion> valoraciones,
			Especificacion especificaciones) {
		super();
		this.id = id;
		this.stock = stock;
		this.precio = precio;
		this.nombre = nombre;
		this.categoria = categoria;
		this.valoraciones = valoraciones;
		this.especificaciones = especificaciones;
	}
	public Dispositivo() {
		super();
	}
	@Override
	public String toString() {
		return "Dipositivo [id=" + id + ", stock=" + stock + ", precio=" + precio + ", nombre=" + nombre
				+ ", categoria=" + categoria + ", valoraciones=" + valoraciones + ", especificaciones="
				+ especificaciones + "]";
	}
	
}
