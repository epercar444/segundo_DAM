package MongoDB.simulacion.modelo;

import MongoDB.simulacion.utils.TipoHabitacion;

public class Habitacion {
	private TipoHabitacion tipo;
	private int capacidad;
	private boolean disponible;
	private double precio;
	public TipoHabitacion getTipo() {
		return tipo;
	}
	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Habitacion(TipoHabitacion tipo, int capacidad, boolean disponible, double precio) {
		super();
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.disponible = disponible;
		this.precio = precio;
	}
	public Habitacion() {
		super();
	}
	@Override
	public String toString() {
		return "Habitacion [tipo=" + tipo + ", capacidad=" + capacidad + ", disponible=" + disponible + ", precio="
				+ precio + "]";
	}
	
	
}
