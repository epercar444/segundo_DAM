package dao;

import modelos.Revista;
import utiles.AbstractDao;

public class ArticuloDao extends AbstractDao<Revista> {

	public ArticuloDao() {
		setClase(Revista.class);
	}

}