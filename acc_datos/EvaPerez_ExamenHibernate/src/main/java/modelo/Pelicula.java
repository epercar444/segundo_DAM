package modelo;

import java.util.Objects;
import java.util.Set;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
	@Id
	@NotBlank
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPelicula; 
	
	@NotBlank
	private String titulo;
	
	private String genero;
	private int duracion;
	
	@ManyToMany
	private Set<Sala> salas;

	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public Set<Sala> getSalas() {
		return salas;
	}
	public void setSalas(Set<Sala> salas) {
		this.salas = salas;
	}
	public Pelicula(String titulo, String genero, int duracion, Set<Sala> salas) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.salas = salas;
	}
	public Pelicula() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPelicula);
	}
	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo + ", genero=" + genero + ", duracion="
				+ duracion + "]";
	}
	
	
	
	
}
