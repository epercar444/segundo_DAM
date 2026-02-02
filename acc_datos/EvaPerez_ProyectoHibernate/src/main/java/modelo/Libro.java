package modelo;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLibro; 
	
	private String titulo;
	private int pagTotales;
	
	@OneToMany(mappedBy="libro")
	   private List<Anotacion> anotaciones;
	
	@OneToMany(mappedBy="libro")
	   private List<Valoracion> valoraciones;
	
	@ManyToOne
	@JoinColumn(name="idAutor")
	   private Autor autor;
	
	@ManyToOne
	@JoinColumn(name="idEditorial")
	   private Editorial editorial;
	
	@ManyToMany(mappedBy = "libros")
	private Set<Lector> lectores;
	

	public Set<Lector> getLectores() {
		return lectores;
	}

	public void setLectores(Set<Lector> lectores) {
		this.lectores = lectores;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPagTotales() {
		return pagTotales;
	}

	public void setPagTotales(int pagTotales) {
		this.pagTotales = pagTotales;
	}

	public List<Anotacion> getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(List<Anotacion> anotaciones) {
		this.anotaciones = anotaciones;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLibro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return idLibro == other.idLibro;
	}

	public Libro(String titulo, int pagTotales, List<Anotacion> anotaciones, List<Valoracion> valoraciones,
			Autor autor, Editorial editorial, Set<Lector> lectores) {
		super();
		this.titulo = titulo;
		this.pagTotales = pagTotales;
		this.anotaciones = anotaciones;
		this.valoraciones = valoraciones;
		this.autor = autor;
		this.editorial = editorial;
		this.lectores = lectores;
	}

	public Libro() {
		super();
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", pagTotales=" + pagTotales +"]";
	}

	
	
	
	
}
