package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelos.Evento;
import modelos.Ubicacion;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class EventoDao extends AbstractDao<Evento> {

	public EventoDao() {
		setClase(Evento.class);
	}
	
	public List<Object[]> getEventosXDuracion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "SELECT nombre,tipoEvento,duracion FROM "+ Evento.class.getName()+" WHERE duracion > 91";
		Query<Object[]> query = sesion.createQuery(queryString, Object[].class);
		List<Object[]> eventosXduracion = query.getResultList();
		
		return eventosXduracion;
	}
	
	public List<Object[]> getEventosXFiltros() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "SELECT nombre,ubicacion,participantes FROM "+ Evento.class.getName();
		Query<Object[]> query = sesion.createQuery(queryString, Object[].class);
		List<Object[]> eventosXfiltros = query.getResultList();
		
		return eventosXfiltros;
	}
	
	public List<Object[]> getEventosParametrizados(Ubicacion u) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "SELECT nombre,tipoEvento,fecha FROM "+ Evento.class.getName()+" WHERE ubicacion = :ubi";
		Query<Object[]> query = sesion.createQuery(queryString, Object[].class);
		query.setParameter("ubi", u);
		List<Object[]> eventosParametrizados = query.getResultList();
		
		return eventosParametrizados;
	}

}