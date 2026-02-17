package myapp.models;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	@Column
	private String titulo;
	@Column
	private int pagTotales;
	@JsonIgnoreProperties("librosEscritos")
	@ToString.Exclude
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="autor_id")
	   private Autor autor;
	@JsonIgnoreProperties("libros")
	@ToString.Exclude
	@ManyToMany(mappedBy = "libros",cascade=CascadeType.MERGE)
	private Set<Lector> lectores;
	
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
		Libro other = (Libro) obj;
		return id == other.id;
	}
	public Libro(String titulo, int pagTotales, Autor autor, Set<Lector> lectores) {
		super();
		this.titulo = titulo;
		this.pagTotales = pagTotales;
		this.autor = autor;
		this.lectores = new HashSet<>();
	}
	
	
	
	
}
