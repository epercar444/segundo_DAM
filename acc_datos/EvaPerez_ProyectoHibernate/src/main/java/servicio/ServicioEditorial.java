package servicio;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelo.Editorial;
import repositorio.RepositorioEditorial;
import utils.HibernateUtil;

public class ServicioEditorial {
	RepositorioEditorial repo;

	public ServicioEditorial() {
		super();
		this.repo = new RepositorioEditorial();
	}
	
	public void addEditorial (Editorial e) {
		repo.create(e);
	}
	
	public void removeEditorial (Editorial e) {
		repo.delete(e);
	}
	
	public Editorial getEditorial (int idEditorial) {
		return repo.get(idEditorial);
	}
	
	public void updateEditorial (Editorial e) {
		repo.update(e);
	}
	
	public long countEditorial() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "SELECT count(*) FROM "+ Editorial.class.getName();		
		TypedQuery<Long> query = sesion.createQuery(queryString, Long.class);
		Long numElementos = query.getSingleResult();
		
		return numElementos;
	}
}
