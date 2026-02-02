package modelo;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class Lector {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLector; 
	
	//Es obligatorio usar la notación @Column(name="nombreCampo")
	// Si las columnas de la tablas se llaman diferentes que los atributos
	// @Column(name="username")
	
	private String username,password;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name= "idConfig")
	private Configuracion config;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idAnotacion")
	private List<Anotacion> anotaciones;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idValoracion")
	private List<Valoracion> valoraciones;

	public int getId() {
		return idLector;
	}

	public void setId(int id) {
		this.idLector = id;
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
		return config;
	}

	public void setConfig(Configuracion config) {
		this.config = config;
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

	public Lector(int id, String username, String password, Configuracion config, List<Anotacion> anotaciones,
			List<Valoracion> valoraciones) {
		super();
		this.idLector = id;
		this.username = username;
		this.password = password;
		this.config = config;
		this.anotaciones = anotaciones;
		this.valoraciones = valoraciones;
	}

	public Lector() {
		super();
	}
	
	//ToString
	
	
	
	
	
}
