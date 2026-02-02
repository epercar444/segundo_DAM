package repositorio;

import modelo.Autor;
import utils.AbstractDao;

public class RepositorioAutor extends AbstractDao<Autor>{

	public RepositorioAutor() {
		setClase(Autor.class);
	}

}
