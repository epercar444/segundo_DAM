package repositorio;

import modelo.Reunion;
import modelo.Sala;
import util.AbstractDao;

public class RepositorioSala extends AbstractDao<Sala>{
	public RepositorioSala() {
		//sin super
		setClase(Sala.class);
	}
}


