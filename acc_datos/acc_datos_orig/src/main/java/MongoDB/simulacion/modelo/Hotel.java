package MongoDB.simulacion.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {
	private String id,nombre,fechaApertura;
	private int estrellas;
	private boolean admiteMascotas;
	private List<Habitacion> habitaciones;
	private Ubicacion ubicacion;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public boolean isAdmiteMascotas() {
		return admiteMascotas;
	}
	public void setAdmiteMascotas(boolean admiteMascotas) {
		this.admiteMascotas = admiteMascotas;
	}
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Hotel(String id, String nombre, String fechaApertura, int estrellas, boolean admiteMascotas,
			List<Habitacion> habitaciones, Ubicacion ubicacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaApertura = fechaApertura;
		this.estrellas = estrellas;
		this.admiteMascotas = admiteMascotas;
		this.habitaciones = new ArrayList<>();
		this.ubicacion = ubicacion;
	}
	public Hotel() {
		super();
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
		Hotel other = (Hotel) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nombre=" + nombre + ", fechaApertura=" + fechaApertura + ", estrellas="
				+ estrellas + ", admiteMascotas=" + admiteMascotas + ", habitaciones=" + habitaciones + ", ubicacion="
				+ ubicacion + "]";
	}
	
	
	
	
}
