package modelo;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Libro {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLibro; 
	
	private String titulo;
	private int pagTotales;
	
	@OneToMany(mappedBy="libro")
	   private List<Anotacion> anotaciones;
	
	@OneToMany(mappedBy="libro")
	   private List<Valoracion> valoraciones;
	
	
}
