package hibernate;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import modelo.Reunion;
 

public class TestCRUDReunion {
	private static final Logger logger = LogManager.getLogger(TestCRUDReunion.class);
	@Test
	void testCreateReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		//Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		Reunion reunion = new Reunion();
		reunion.setAsunto("esta es la segunda prueba con hibernate");
		reunion.setFecha(LocalDateTime.now());
		sesion.persist(reunion);
		assertNotNull(reunion.getIdReunion());
		tx.commit();	
	}
	
	@Test
	void testDeleteReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		//Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		Reunion r = sesion.find(Reunion.class, 302);//segundo número es el id de la reunión que queremos eliminar
		sesion.remove(r);
		Reunion borrada = sesion.get(Reunion.class, 302);
		assertNull(borrada);
		tx.commit();	
	}
	
	@Test
	void testUpdateReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Reunion r = sesion.find(Reunion.class, 1);
		sesion.beginTransaction();
		r.setAsunto("Nuevo Asunto --");
		sesion.getTransaction().commit();
		assertTrue("Nuevo Asunto --".equals(r.getAsunto()));
		sesion.close();
	}
	
	@Test
	void testRetrieveReunionExiste() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Reunion r = sesion.find(Reunion.class, 1);
		logger.debug("El asunto es:"+r.getAsunto());
		assertNotNull(r);
		assertTrue("mi reunion de hoy".equals(r.getAsunto()));
		sesion.close();
		
	}
	@Test
	void testRetrieveReunionNOExiste() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Reunion r = sesion.find(Reunion.class, 11111);
		assertNull(r);
		sesion.close();
		
	}


}
