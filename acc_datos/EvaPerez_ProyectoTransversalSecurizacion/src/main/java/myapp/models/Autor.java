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
public class Autor extends Usuario{
	@Column
	private String pais_origen;
	@JsonIgnoreProperties("autor")
	@ToString.Exclude
	@OneToMany(mappedBy="autor",cascade= CascadeType.ALL)
	   private List<Libro> librosEscritos;
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (this == obj)
			res = true;
		if (!super.equals(obj))
			res = false;
		if (getClass() != obj.getClass())
			res = false;
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
		return "Autor [pais_origen=" + pais_origen + "," + super.toString() + "]";
	}
	
	
	
	
}
