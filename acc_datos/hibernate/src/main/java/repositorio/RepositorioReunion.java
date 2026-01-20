package repositorio;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelo.Reunion;
import util.AbstractDao;
import util.HibernateUtil;

public class RepositorioReunion extends AbstractDao<Reunion>{
	public RepositorioReunion() {
		//sin super
		setClase(Reunion.class);
	}

}
