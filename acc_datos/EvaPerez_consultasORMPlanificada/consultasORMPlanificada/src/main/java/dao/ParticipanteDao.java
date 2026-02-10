package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;
import modelos.Participante;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class ParticipanteDao extends AbstractDao<Participante> {

	public ParticipanteDao() {
		setClase(Participante.class);
	}
	
	public List<Object[]> getParticipantesXOrder () {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "SELECT apellidos,nombre,email FROM "+ Participante.class.getName()+" ORDER BY apellidos,nombre ASC";
		Query<Object[]> query = sesion.createQuery(queryString, Object[].class);
		List<Object[]> participanteXapellidos= query.getResultList();
		
		return participanteXapellidos;
	}
}