package repositorio;

import modelo.Sala;
import utils.AbstractDao;

public class RepositorioSala extends AbstractDao<Sala>{
	
	public RepositorioSala() {
		setClase(Sala.class);
		}

}

