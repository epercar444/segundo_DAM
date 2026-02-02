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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lector")
public class Lector {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLector; 
	
	//Es obligatorio usar la notación @Column(name="nombreCampo")
	// Si las columnas de la tablas se llaman diferentes que los atributos
	// @Column(name="username")
	
	private String username,password;
	
	@OneToOne (cascade = CascadeType.PERSIST)
	@JoinColumn (name= "idConfig")
	private Configuracion configuracion;
	
	@OneToMany(mappedBy = "lector")
	private List<Anotacion> anotaciones;
	
	@OneToMany(mappedBy = "lector")
	private List<Valoracion> valoraciones;
	
	@ManyToMany
	private Set<Libro> libros;
	
	

	public int getIdLector() {
		return idLector;
	}

	public void setIdLector(int idLector) {
		this.idLector = idLector;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Configuracion getConfig() {
		return configuracion;
	}

	public void setConfig(Configuracion config) {
		this.configuracion = config;
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

	@Override
	public int hashCode() {
		return Objects.hash(idLector);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lector other = (Lector) obj;
		return idLector == other.idLector;
	}

	public Lector(String username, String password, Configuracion configuracion, List<Anotacion> anotaciones,
			List<Valoracion> valoraciones, Set<Libro> libros) {
		super();
		this.username = username;
		this.password = password;
		this.configuracion = configuracion;
		this.anotaciones = anotaciones;
		this.valoraciones = valoraciones;
		this.libros = libros;
	}

	public Lector() {
		super();
	}

	@Override
	public String toString() {
		return "Lector [idLector=" + idLector + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
	
	
	
	
}
