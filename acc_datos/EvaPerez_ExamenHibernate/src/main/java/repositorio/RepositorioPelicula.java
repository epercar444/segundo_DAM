package repositorio;

import modelo.Pelicula;
import utils.AbstractDao;

public class RepositorioPelicula extends AbstractDao<Pelicula>{

	public RepositorioPelicula() {
		setClase(Pelicula.class);
	}
	
}
