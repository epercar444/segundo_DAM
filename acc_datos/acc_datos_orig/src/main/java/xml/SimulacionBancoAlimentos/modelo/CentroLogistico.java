package xml.SimulacionBancoAlimentos.modelo;

import java.util.List;
import java.util.Objects;

public class CentroLogistico {
	private int numComedores;
	private String nombre,ciudad,id;
	private List<Trabajador> trabajadores;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumComedores() {
		return numComedores;
	}
	public void setNumComedores(int numComedores) {
		this.numComedores = numComedores;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}
	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
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
		CentroLogistico other = (CentroLogistico) obj;
		return id == other.id;
	}
	public CentroLogistico(String id, int numComedores, String nombre, String ciudad, List<Trabajador> trabajadores) {
		super();
		this.id = id;
		this.numComedores = numComedores;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.trabajadores = trabajadores;
	}
	public CentroLogistico() {
		super();
	}
	@Override
	public String toString() {
		return "CentroLogistico [id=" + id + ", numComedores=" + numComedores + ", nombre=" + nombre + ", ciudad="
				+ ciudad + ", trabajadores=" + trabajadores + "]";
	}
	
	
}
