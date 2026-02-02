package servicio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;
import modelo.Lector;
import modelo.Libro;
import repositorio.RepositorioLector;
import utils.HibernateUtil;

public class ServicioLector {
	RepositorioLector repo;

	public ServicioLector() {
		super();
		this.repo = new RepositorioLector();
	}
	
	public void addLector (Lector l) {
		repo.create(l);
	}
	
	public void removeLector (Lector l) {
		repo.delete(l);
	}
	
	public Lector getLector (int idLector) {
		return repo.get(idLector);
	}
	
	public void updateLector (Lector l) {
		repo.update(l);
	}
	
	public List<String> getCampo () {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "SELECT username FROM "+ Lector.class.getName();		
		Query<String> query = sesion.createQuery(queryString, String.class);
		List<String> usernames = query.getResultList();
		
		return usernames;
	}
	
	public List<Lector> parametrizarDos () {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "FROM "+ Lector.class.getName()+" WHERE password =  :contraseña";
		TypedQuery<Lector> query = sesion.createQuery(queryString, Lector.class);
		query.setParameter("contraseña", "pass123");
		List<Lector> lectorParametrizado= query.getResultList();
		
		return lectorParametrizado;
	}
	
	public List<Lector> obtenerLectoresOrdenados() {
	    String queryString = "FROM " + Lector.class.getName() + " l ORDER BY l.username ASC";	
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    Query<Lector> query = sesion.createQuery(queryString, Lector.class);
	    List<Lector> lista = query.getResultList();
	    
	    return lista;
	}
}
