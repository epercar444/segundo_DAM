package modelo;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "valoracion")
public class Valoracion {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idValoracion; 
	
	private int puntuacion;
	private String comentario;
	private LocalDate fechaPublicacion;
	
	@ManyToOne
    @JoinColumn(name = "idLibro")
    private Libro libro;
    
    @ManyToOne
    @JoinColumn(name = "idLector")
    private Lector lector;

	public int getIdValoracion() {
		return idValoracion;
	}

	public void setIdValoracion(int id) {
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

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
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

	public Valoracion(int puntuacion, String comentario, LocalDate fechaPublicacion, Libro libro,
			Lector lector) {
		super();
		this.puntuacion = puntuacion;
		this.comentario = comentario;
		this.fechaPublicacion = fechaPublicacion;
		this.libro = libro;
		this.lector = lector;
	}

	public Valoracion() {
		super();
	}

	@Override
	public String toString() {
		return "Valoracion [idValoracion=" + idValoracion + ", puntuacion=" + puntuacion + ", comentario=" + comentario
				+ ", fechaPublicacion=" + fechaPublicacion + ", libro=" + libro + ", lector=" + lector + "]";
	}
	
	
	
}
