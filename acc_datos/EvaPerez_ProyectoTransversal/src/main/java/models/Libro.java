package models;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLibro; 
	@Column
	private String titulo;
	@Column
	private int pagTotales;
	@ManyToOne
	@JoinColumn(name="idAutor")
	   private Autor autor;
	@Column
	@ManyToMany(mappedBy = "libros")
	private Set<Lector> lectores;

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
	
	
	
	
}
