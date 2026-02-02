package modelo;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAutor; 
	
	private String nombre,pais_origen;
	
	@OneToMany(mappedBy="autor")
	   private List<Libro> librosEscritos;

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais_origen() {
		return pais_origen;
	}

	public void setPais_origen(String pais_origen) {
		this.pais_origen = pais_origen;
	}

	public List<Libro> getLibrosEscritos() {
		return librosEscritos;
	}

	public void setLibrosEscritos(List<Libro> librosEscritos) {
		this.librosEscritos = librosEscritos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAutor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return idAutor == other.idAutor;
	}

	public Autor(String nombre, String pais_origen, List<Libro> librosEscritos) {
		super();
		this.nombre = nombre;
		this.pais_origen = pais_origen;
		this.librosEscritos = librosEscritos;
	}

	public Autor() {
		super();
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", pais_origen=" + pais_origen + "]";
	}
	
	
}
