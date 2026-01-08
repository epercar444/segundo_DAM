package xml.SimulacionF1.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Equipo {
	private String nombre;
	private List<Piloto> pilotos;
	private int id,puntos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Piloto> getPilotos() {
		return pilotos;
	}
	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
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
		Equipo other = (Equipo) obj;
		return id == other.id;
	}
	public Equipo(String nombre, Set<Piloto> pilotos, int id, int puntos) {
		super();
		this.nombre = nombre;
		this.pilotos = new ArrayList<>();
		this.id = id;
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", pilotos=" + pilotos + ", id=" + id + ", puntos=" + puntos + "]";
	}
	public Equipo() {
		super();
	}
	
	
}
