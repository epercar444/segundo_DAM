package modelo;

import java.util.Objects;
import java.util.Set;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala {
	@Id
	@NotBlank
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSala; 
	
	private String nombre;
	private int capacidad;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idCine")
	private Cine cine;
	
	@ManyToMany(mappedBy = "salas",cascade=CascadeType.PERSIST) 
	private Set<Pelicula> peliculas;

	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public Cine getCine() {
		return cine;
	}
	public void setCine(Cine cine) {
		this.cine = cine;
	}
	public Set<Pelicula> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	public Sala(String nombre, int capacidad,Cine cine,Set<Pelicula> peliculas) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.cine = cine;
		this.peliculas = peliculas;
	}
	public Sala() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(idSala);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return idSala == other.idSala;
	}
	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", nombre=" + nombre + ", capacidad=" + capacidad + "]";
	}
	
	
	
	
	
}
