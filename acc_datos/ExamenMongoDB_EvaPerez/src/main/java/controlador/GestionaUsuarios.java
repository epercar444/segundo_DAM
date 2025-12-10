package controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import configuration.MongoDBConexion;
import modelo.Evento;
import modelo.Preferencias;
import modelo.Usuario;
import servicio.UsuarioServicio;
import utils.PlanActivo;

public class GestionaUsuarios {
	private static final Logger logger = LogManager.getLogger(GestionaUsuarios.class);
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();
		UsuarioServicio servicio = new UsuarioServicio(db);
		
		List<Usuario> usuarios = servicio.read();
		//prueba salen usuarios
		for (Usuario u : usuarios) {
		logger.info(u);
		}
		
		//prueba addUser (apartado2)
		Preferencias preferenciasPrueba = new Preferencias(true, "EN", false, true);
		Evento eventoPrueba = new Evento("evPrueba", "LOGIN", "Inicio de Sesión Exitoso", "prueba");
		List<Evento> eventosInsert = new ArrayList<>();
		eventosInsert.add(eventoPrueba);
		Usuario usuarioPrueba = new Usuario("usr041", "Prueba", "Prueba", PlanActivo.FREE, "iphone17", preferenciasPrueba, eventosInsert);
		
		servicio.addUser(usuarioPrueba);
		
		//prueba getUser (apartado3)
		logger.info(servicio.getUser("usr002"));
		
		
		//prueba orderBy (apartado1)
		List<Usuario> usuariosOrderBy = servicio.orderBy();
		for (Usuario u : usuariosOrderBy) {
			logger.info(u);
		}
		
		//prueba orderBy2 (apartado1.2)
		Preferencias preferenciasPrueba2 = new Preferencias(true, "EN", false, true);
		Evento eventoPrueba2 = new Evento("evPrueba2", "LOGIN", "Inicio de Sesión Exitoso", "prueba");
		List<Evento> eventosInsert2 = new ArrayList<>();
		eventosInsert.add(eventoPrueba2);
		Usuario usuarioPrueba2 = new Usuario("usr042", "Prueba", "user001@fitdroid.com", PlanActivo.FREE, "iphone17", preferenciasPrueba2, eventosInsert2);
		servicio.addUser(usuarioPrueba2);
		List<Usuario> usuariosOrderBy2 = servicio.orderBy();
		for (Usuario u : usuariosOrderBy2) {
			logger.info(u);
		}
		
		//prueba updateLanguage (apartado4)
		logger.info(servicio.updateLanguage());
		for (Usuario u : usuarios) {
		logger.info(u);
		}
		
		
		//prueba deleteAnual (apartado5) 
		logger.info(servicio.deleteAnual());
		for (Usuario u : usuarios) {
		logger.info(u);
		}
		
		//prueba getForCondition (apartado6)
		List<Usuario> usuariosCondition = servicio.getForCondition();
		for (Usuario u : usuariosCondition) {
			logger.info(u);
		}
		
		//prueba updatePlanActivo (apartado7) 
		logger.info(servicio.updatePlanActivo());
		for (Usuario u : usuarios) {
		logger.info(u);
		}
		
		//prueba addEvento (apartado8)
		Evento eventoPrueba3 = new Evento("ev_121", "GPS", "Señal GPS adquirida", "2024-02-12T08:21:00Z");
		logger.info(servicio.addEvent("usr008", eventoPrueba3));
		for (Usuario u : usuarios) {
		logger.info(u);
		}
		
}
}
