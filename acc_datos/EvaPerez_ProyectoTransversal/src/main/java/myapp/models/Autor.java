package myapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity(name = "autor")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	@Column
	private String nombre;
	@Column
	private String pais_origen;
	@JsonIgnoreProperties("autor")
	@ToString.Exclude
	@OneToMany(mappedBy="autor",cascade= CascadeType.ALL)
	   private List<Libro> librosEscritos;

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}
	public Autor(String nombre, String pais_origen, List<Libro> librosEscritos) {
		super();
		this.nombre = nombre;
		this.pais_origen = pais_origen;
		this.librosEscritos = librosEscritos;
	}
	
}
