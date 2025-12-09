package MongoDB.simulacion.controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import MongoDB.configuracion.MongoDBConexion;
import MongoDB.simulacion.modelo.Habitacion;
import MongoDB.simulacion.modelo.Hotel;
import MongoDB.simulacion.servicio.HotelServicio;
import MongoDB.simulacion.utils.TipoHabitacion;

public class GestionaHotel {
	private static final Logger logger = LogManager.getLogger(GestionaHotel.class);
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();
		HotelServicio servicio = new HotelServicio(db);
		
		List<Hotel> hoteles = servicio.read();
		
		/*for (Hotel h : hoteles) {
			logger.info(h);
		}*/
		
		/*List<Hotel> hotelesFiltrados = servicio.filtrarXCodigoPostal();
		for (Hotel h : hotelesFiltrados) {
			logger.info(h);
		}*/
		
		/*List<Hotel> hotelesFiltrados2 = servicio.filtraXSuiteJunior();
		for (Hotel h : hotelesFiltrados2) {
			logger.info(h);
		}*/
		
		//Habitacion habitacionEjemplo = new Habitacion(TipoHabitacion.SUITE_JUNIOR, 2, true, 360);
		//logger.info(servicio.updateHabitacion("h101", habitacionEjemplo));
		/*for (Hotel h : hoteles) {
		logger.info(h);
		}*/
		
		//logger.info(servicio.updateCodigoPostal());
		
		//logger.info(servicio.updateXId());
		
		
		/*logger.info(servicio.pullHab());
		for (Hotel h : hoteles) {
		logger.info(h);*/
		
		logger.info(servicio.calcularMediaEstrellas());
		
		
}
}
