package xml.SimulacionBancoAlimentos.modelo;

import java.time.LocalDate;
import java.util.Objects;

import xml.SimulacionBancoAlimentos.utils.TipoTrabajador;

public class Trabajador {
	private String nombre,dni;
	private LocalDate fecha_nacimiento;
	private TipoTrabajador tipo;
	private String id_centrologistico;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public TipoTrabajador getTipo() {
		return tipo;
	}
	public void setTipo(TipoTrabajador tipo) {
		this.tipo = tipo;
	}
	public String getId_centrologistico() {
		return id_centrologistico;
	}
	public void setId_centrologistico(String id_centrologistico) {
		this.id_centrologistico = id_centrologistico;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajador other = (Trabajador) obj;
		return Objects.equals(dni, other.dni);
	}
	public Trabajador(String nombre, String dni, LocalDate fecha_nacimiento, TipoTrabajador tipo,
			String id_centrologistico) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
		this.tipo = tipo;
		this.id_centrologistico = id_centrologistico;
	}
	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", dni=" + dni + ", fecha_nacimiento=" + fecha_nacimiento + ", tipo="
				+ tipo + ", id_centrologistico=" + id_centrologistico + "]";
	}
	public Trabajador() {
		super();
	}
	
	
	
}
