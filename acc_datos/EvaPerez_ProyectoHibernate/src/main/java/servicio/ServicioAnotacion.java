package servicio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;
import modelo.Anotacion;
import modelo.Lector;
import repositorio.RepositorioAnotacion;
import utils.HibernateUtil;

public class ServicioAnotacion {
	RepositorioAnotacion repo;

	public ServicioAnotacion() {
		super();
		this.repo = new RepositorioAnotacion();
	}
	
	public void addAnotacion (Anotacion a) {
		repo.create(a);
	}
	
	public void removeAnotacion (Anotacion a) {
		repo.delete(a);
	}
	
	public Anotacion getAnotacion (int idAnotacion) {
		return repo.get(idAnotacion);
	}
	
	public void updateAnotacion (Anotacion a) {
		repo.update(a);
	}
	public List<Object[]> getCampos () {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "SELECT idAnotacion,descripcion,pagReferencia FROM "+ Anotacion.class.getName();		
		Query<Object[]> query = sesion.createQuery(queryString, Object[].class);
		List<Object[]> resultado = query.getResultList();
		
		return resultado;
	}
	
	public Double consultaAVG () {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "SELECT avg(a.pagReferencia) FROM "+ Anotacion.class.getName()+" a";		
		TypedQuery<Double> query = sesion.createQuery(queryString, Double.class);
		Double numElementos = query.getSingleResult();
		
		return numElementos;
	}
}
