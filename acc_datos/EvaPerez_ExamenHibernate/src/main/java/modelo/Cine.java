package modelo;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cine")
public class Cine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCine; 
	
	private String ubicacion;
	@NotBlank
	private String nombre;
	
	@OneToMany(mappedBy="cine",cascade = CascadeType.ALL)
	private List<Sala> salas;


	public int getIdCine() {
		return idCine;
	}
	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Sala> getSalas() {
		return salas;
	}
	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
	public Cine(String ubicacion, String nombre, List<Sala> salas) {
		super();
		this.ubicacion = ubicacion;
		this.nombre = nombre;
		this.salas = salas;
	}
	public Cine() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCine);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return idCine == other.idCine;
	}
	@Override
	public String toString() {
		return "Cine [idCine=" + idCine + ", ubicacion=" + ubicacion + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
	
	
}
