package repositorio;

import modelo.Cine;
import utils.AbstractDao;

public class RepositorioCine extends AbstractDao<Cine>{

	public RepositorioCine() {
		setClase(Cine.class);;
	}
	
}
