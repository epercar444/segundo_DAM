package modelos;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulo")
public class Articulo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idArticulo; 
	
	private int numeroPaginaInicio,numeroPaginaFin;
	private String titulo;
	
	@ManyToOne(cascade=CascadeType.MERGE) 
	@JoinColumn(name="idRevista")
	private Revista revista;
	
	@ManyToMany (mappedBy="articulos"/*cascade*/)
	private Set<Autor> autores;
}
