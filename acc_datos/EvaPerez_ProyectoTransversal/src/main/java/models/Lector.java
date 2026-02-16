package models;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "lector")
public class Lector {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLector; 
	@Column
	private String username;
	@Column
	private String password;
	@Column
	@ManyToMany
	private Set<Libro> libros;

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
	
	
}
