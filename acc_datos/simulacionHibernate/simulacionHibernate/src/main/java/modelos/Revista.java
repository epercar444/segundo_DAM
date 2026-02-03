package modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "revista")
public class Revista {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRevista; 
	
	private int numeroRevista,unidadesImpresas;
	private String nombreRevista;
	private LocalDate fecha;
	
	@OneToMany(mappedBy="revista")
	private List<Articulo> articulos;
	

	public int getIdRevista() {
		return idRevista;
	}

	public void setIdRevista(int idRevista) {
		this.idRevista = idRevista;
	}

	public int getNumeroRevista() {
		return numeroRevista;
	}

	public void setNumeroRevista(int numeroRevista) {
		this.numeroRevista = numeroRevista;
	}

	public int getUnidadesImpresas() {
		return unidadesImpresas;
	}

	public void setUnidadesImpresas(int unidadesImpresas) {
		this.unidadesImpresas = unidadesImpresas;
	}

	public String getNombreRevista() {
		return nombreRevista;
	}

	public void setNombreRevista(String nombreRevista) {
		this.nombreRevista = nombreRevista;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Revista(int numeroRevista, String nombreRevista, LocalDate fecha) {
		super();
		this.numeroRevista = numeroRevista;
		this.nombreRevista = nombreRevista;
		this.fecha = fecha;
	}
	
	

	public Revista(int numeroRevista, int unidadesImpresas, String nombreRevista, LocalDate fecha) {
		super();
		this.numeroRevista = numeroRevista;
		this.unidadesImpresas = unidadesImpresas;
		this.nombreRevista = nombreRevista;
		this.fecha = fecha;
	}

	public Revista() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRevista);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		return idRevista == other.idRevista;
	}

	@Override
	public String toString() {
		return "Revista [idRevista=" + idRevista + ", numeroRevista=" + numeroRevista + ", unidadesImpresas="
				+ unidadesImpresas + ", nombreRevista=" + nombreRevista + "]";
	}
	
	
	
}
