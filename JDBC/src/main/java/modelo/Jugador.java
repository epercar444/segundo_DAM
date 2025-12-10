package modelo;

import java.util.Objects;

public class Jugador {
	private int id,puntos_totales;
	private String nombre,email;
	public Jugador(String email, String nombre, int puntos_totales) {
		super(); //no ponemos id porque en la bbdd es autoincremental
		this.puntos_totales = puntos_totales;
		this.nombre = nombre;
		this.email = email;
	}
	public Jugador() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPuntos_totales() {
		return puntos_totales;
	}
	public void setPuntos_totales(int puntos_totales) {
		this.puntos_totales = puntos_totales;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", puntos_totales=" + puntos_totales + ", nombre=" + nombre + ", email=" + email
				+ "]";
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
		Jugador other = (Jugador) obj;
		return id == other.id;
	}
	
	
}
