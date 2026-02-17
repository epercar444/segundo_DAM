package myapp.models;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@Entity(name = "lector")
public class Lector {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	@Column
	private String username;
	@Column
	private String password;
	@JsonIgnore
	@ToString.Exclude
	@ManyToMany(mappedBy="lectores")
	private Set<Libro> libros = new HashSet<>();

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
		Lector other = (Lector) obj;
		return id == other.id;
	}
	public Lector(String username, String password, Set<Libro> libros) {
		super();
		this.username = username;
		this.password = password;
		this.libros = libros;
	}
	
	
}
