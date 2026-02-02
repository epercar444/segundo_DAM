package servicio;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelo.Libro;
import repositorio.RepositorioLibro;
import utils.HibernateUtil;

public class ServicioLibro {
	RepositorioLibro repo;

	public ServicioLibro() {
		super();
		this.repo = new RepositorioLibro();
	}
	
	public void addLibro (Libro l) {
		repo.create(l);
	}
	
	public void removeLibro (Libro l) {
		repo.delete(l);
	}
	
	public Libro getLibro (int idLibro) {
		return repo.get(idLibro);
	}
	
	public void updateLibro (Libro l) {
		repo.update(l);
	}
	
	public Libro getOneBook () {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "FROM " + Libro.class.getName();
		TypedQuery<Libro> query = sesion.createQuery(queryString, Libro.class);
		Libro l = query.getSingleResult();
		
		return l;
		
	}
	
	public List<Libro> parametrizarUno () {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "FROM "+ Libro.class.getName()+" WHERE pagTotales <  :numPaginas";
		TypedQuery<Libro> query = sesion.createQuery(queryString, Libro.class);
		query.setParameter("numPaginas", 2000);
		List<Libro> librosParametrizados= query.getResultList();
		
		return librosParametrizados;
	}
}
