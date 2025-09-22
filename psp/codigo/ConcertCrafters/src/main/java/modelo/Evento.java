package modelo;

import java.time.LocalDate;
import java.util.Objects;

import enum_.Estado_Crafters;
import excepciones.CraftersException;

public abstract class Evento {
	static int contador = 0;
	int id, num_entradas_vendidas, cap_max_asist;
	String nombre;
	final LocalDate fecha;
	Estado_Crafters estado;
	public Evento(int num_entradas_vendidas, int cap_max_asist, String nombre, LocalDate fecha, Estado_Crafters estado) throws CraftersException {
		super();
		contador++;
		this.id = id + contador;
		this.num_entradas_vendidas = getNum_entradas_vendidas();
		this.cap_max_asist = cap_max_asist;
		this.nombre = nombre;
		this.fecha = fecha;
		this.estado = estado;
	}
	
	public Estado_Crafters getEstado() {
		return estado;
	}
	public void setEstado(Estado_Crafters estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum_entradas_vendidas() throws CraftersException {
		if (num_entradas_vendidas < 0 || num_entradas_vendidas > cap_max_asist) {
			throw new CraftersException ("No es posible construir un evento con esos datos");
		}
		else {
		return num_entradas_vendidas;
		}
	}
	public void setNum_entradas_vendidas(int num_entradas_vendidas) {
		this.num_entradas_vendidas = num_entradas_vendidas;
	}
	public int getCap_max_asist() {
		return cap_max_asist;
	}
	public void setCap_max_asist(int cap_max_asist) {
		this.cap_max_asist = cap_max_asist;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
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
		Evento other = (Evento) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", estado=" + estado + "]";
	}	
	

	
	
	
	
	public void modificaEstado (Evento e, Estado_Crafters estado_nuevo) throws CraftersException {
		if (this.estado.equals(this.estado.PENDIENTE) && (estado_nuevo.equals(this.estado.PROGRAMADO) || estado_nuevo.equals(this.estado.CANCELADO) || estado_nuevo.equals(this.estado.FINALIZADO) || estado_nuevo.equals(this.estado.APLAZADO))) {
			this.setEstado(estado_nuevo);
		}
		else if (this.estado.equals(this.estado.PROGRAMADO) && (estado_nuevo.equals(this.estado.CANCELADO) || estado_nuevo.equals(this.estado.FINALIZADO) || estado_nuevo.equals(this.estado.APLAZADO))) {
			this.setEstado(estado_nuevo);
		}
		else if (this.estado.equals(this.estado.CANCELADO) && (estado_nuevo.equals(this.estado.FINALIZADO) || estado_nuevo.equals(this.estado.APLAZADO))) {
			this.setEstado(estado_nuevo);
		}
		else if (this.estado.equals(this.estado.FINALIZADO) && (estado_nuevo.equals(this.estado.APLAZADO))) {
			this.setEstado(estado_nuevo);
		}
		else {
			throw new CraftersException ("No es posible pasar al estado: " + estado_nuevo);
		}
	}
	
	public void getPorcentajeOcupacion () {
		int porcentaje = (num_entradas_vendidas / cap_max_asist) * 100;
		System.out.println(porcentaje + "%");
	}
	
	public void getPorcentajeOcupacion (int numeroEntradas) throws CraftersException {
		int porcentaje = 0;
		int num_entradas_final = num_entradas_vendidas + numeroEntradas;
		if (num_entradas_final > cap_max_asist) {
			throw new CraftersException ("El numero de entradas finales vendidas no puede ser mayor a la capacidad");
		}
		else {
			porcentaje = (num_entradas_final + cap_max_asist) * 100;
			System.out.println(porcentaje + "%");
		}
	}
	
	public abstract double calcularCosteBase ();
}

