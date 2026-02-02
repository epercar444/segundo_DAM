package servicio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import modelo.Autor;
import repositorio.RepositorioAutor;
import utils.HibernateUtil;

public class ServicioAutor {
	RepositorioAutor repo;

	public ServicioAutor() {
		super();
		this.repo = new RepositorioAutor();
	}
	
	public void addAutor (Autor a) {
		repo.create(a);
	}
	
	public void removeAutor (Autor a) {
		repo.delete(a);
	}
	
	public Autor getAutor (int idAutor) {
		return repo.get(idAutor);
	}
	
	public void updateAutor (Autor a) {
		repo.update(a);
	}
	
	public List<Autor> consultaFiltro() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String hql = "FROM Autor a WHERE a.nombre LIKE :patron";
		Query query = sesion.createQuery(hql);
		query.setParameter("patron", "M%"); 
		List<Autor> lista = query.list();
		
		return lista;

	}
	
	public void actualizarCriteria(int idAutor) {
	    // 1. Abrimos la sesión
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    
	    try {
	        //iniciamos transicción (no va sino)
	        sesion.beginTransaction();
	        CriteriaBuilder cb = sesion.getCriteriaBuilder();
	        CriteriaUpdate<Autor> update = cb.createCriteriaUpdate(Autor.class);
	        Root<Autor> root = update.from(Autor.class);
	        update.set("nombre", "Miguel de Cervantes");
	        update.where(cb.equal(root.get("idAutor"), idAutor));
	        //Ejecutamos la consulta
	        sesion.createMutationQuery(update).executeUpdate();
	        //Guardar cambios permanentemente
	        sesion.getTransaction().commit();
	    } catch (Exception e) {
	        if (sesion.getTransaction() != null) {
	            sesion.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        sesion.close();
	    }
	}
	
	/*public void deleteCriteria(int idAutor) {
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    try {
	        sesion.beginTransaction();
	        CriteriaBuilder cb = sesion.getCriteriaBuilder();
	        CriteriaDelete<Autor> delete = cb.createCriteriaDelete(Autor.class);
	        Root<Autor> root = delete.from(Autor.class); 
	        delete.where(cb.equal(root.get("idAutor"), idAutor));
	        int filas = sesion.createMutationQuery(delete).executeUpdate(); 
	        sesion.getTransaction().commit(); 
	        System.out.println("Filas borradas con Criteria: " + filas);
	    } catch (Exception e) {
	        if (sesion.getTransaction() != null) sesion.getTransaction().rollback();
	        e.printStackTrace();
	    } finally {
	        sesion.close();
	    }
	}*/ //No va
}
