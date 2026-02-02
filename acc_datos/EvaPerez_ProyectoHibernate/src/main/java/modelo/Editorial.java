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
@Table(name = "editorial")
public class Editorial {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEditorial;
	
	private String nombre,pais;
	
	@OneToMany(mappedBy="editorial")
	   private List<Libro> librosEditorial;

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Libro> getLibrosEditorial() {
		return librosEditorial;
	}

	public void setLibrosEditorial(List<Libro> librosEditorial) {
		this.librosEditorial = librosEditorial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEditorial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editorial other = (Editorial) obj;
		return idEditorial == other.idEditorial;
	}

	public Editorial(String nombre, String pais, List<Libro> librosEditorial) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.librosEditorial = librosEditorial;
	}

	public Editorial() {
		super();
	}

	@Override
	public String toString() {
		return "Editorial [idEditorial=" + idEditorial + ", nombre=" + nombre + ", pais=" + pais + "]";
	}
	
	
}
