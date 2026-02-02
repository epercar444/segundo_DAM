package repositorio;

import modelo.Libro;
import utils.AbstractDao;

public class RepositorioLibro extends AbstractDao<Libro>{

	public RepositorioLibro() {
		setClase(Libro.class);
	}
	
}
