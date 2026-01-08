package xml.SimulacionF1.modelo;

import java.util.Objects;

public class Piloto {
	private String nombre,pais;
	private int id,puntos,idEquipo;
	
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
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

	public Piloto(String nombre, String pais, int id, int puntos, int idEquipo) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.id = id;
		this.puntos = puntos;
		this.idEquipo = idEquipo;
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
		Piloto other = (Piloto) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Piloto [nombre=" + nombre + ", pais=" + pais + ", id=" + id + ", puntos=" + puntos + ", idEquipo="
				+ idEquipo + "]";
	}
	public Piloto() {
		super();
	}
	
}
