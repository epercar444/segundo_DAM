package models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "autor")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAutor; 
	@Column
	private String nombre;
	@Column
	private String pais_origen;
	@Column
	@OneToMany(mappedBy="autor")
	   private List<Libro> librosEscritos;

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
	
}
