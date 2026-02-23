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
public class Lector extends Usuario{
	@JsonIgnore
	@ToString.Exclude
	@ManyToMany(mappedBy="lectores")
	private Set<Libro> libros = new HashSet<>();

	@Override
	public boolean equals(Object obj) {
		boolean res= false;
		if (this == obj)
			res= true;
		if (!super.equals(obj))
			res= false;
		if (getClass() != obj.getClass())
			res=  false;
		return res;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Lector [" + super.toString() + "]";
	}
	
	
	
	

	
	
	
	
	
}
