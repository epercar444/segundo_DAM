package repositorio;

import modelo.Editorial;
import utils.AbstractDao;

public class RepositorioEditorial extends AbstractDao<Editorial>{

	public RepositorioEditorial() {
		setClase(Editorial.class);
	}

}
