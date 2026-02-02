package repositorio;

import modelo.Valoracion;
import utils.AbstractDao;

public class RepositorioValoracion extends AbstractDao<Valoracion>{

	public RepositorioValoracion() {
		setClase(Valoracion.class);
	}

}
