package repositorio;

import modelo.Configuracion;
import utils.AbstractDao;

public class RepositorioConfiguracion extends AbstractDao<Configuracion>{

	public RepositorioConfiguracion() {
		setClase(Configuracion.class);
	}

}
