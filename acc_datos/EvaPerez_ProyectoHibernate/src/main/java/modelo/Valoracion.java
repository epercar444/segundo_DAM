package modelo;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class Valoracion {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idValoracion; 
	
	private int puntuacion;
	private String comentario;
	private LocalDate fechaPublicacion;
	
	@ManyToMany(mappedBy="valoraciones", cascade = CascadeType.ALL)
	private Set<Libro> libros;
	
	@ManyToMany(mappedBy="valoraciones", cascade = CascadeType.ALL)
	private Set<Lector> lector;

	public int getId() {
		return idValoracion;
	}

	public void setId(int id) {
		this.idValoracion = id;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	public Set<Lector> getLector() {
		return lector;
	}

	public void setLector(Set<Lector> lector) {
		this.lector = lector;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idValoracion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valoracion other = (Valoracion) obj;
		return idValoracion == other.idValoracion;
	}

	public Valoracion(int id, int puntuacion, String comentario, LocalDate fechaPublicacion, Set<Libro> libros,
			Set<Lector> lector) {
		super();
		this.idValoracion = id;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
		this.fechaPublicacion = fechaPublicacion;
		this.libros = libros;
		this.lector = lector;
	}

	public Valoracion() {
		super();
	}
	
	
	//ToString
}
