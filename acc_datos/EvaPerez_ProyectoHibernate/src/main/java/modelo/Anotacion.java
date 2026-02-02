package modelo;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Anotacion {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAnotacion; 
	
	private String descripcion;
	private int pagReferencia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idLector")
	   private Lector lector;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idLibro")
	   private Libro libro;

	public int getId() {
		return idAnotacion;
	}

	public void setId(int id) {
		this.idAnotacion = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPagReferencia() {
		return pagReferencia;
	}

	public void setPagReferencia(int pagReferencia) {
		this.pagReferencia = pagReferencia;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAnotacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anotacion other = (Anotacion) obj;
		return idAnotacion == other.idAnotacion;
	}

	public Anotacion(int id, String descripcion, int pagReferencia, Lector lector, Libro libro) {
		super();
		this.idAnotacion = id;
		this.descripcion = descripcion;
		this.pagReferencia = pagReferencia;
		this.lector = lector;
		this.libro = libro;
	}

	public Anotacion() {
		super();
	}
	
	//ToString
}
