package MongoDB.simulacion.servicio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import MongoDB.simulacion.modelo.Habitacion;
import MongoDB.simulacion.modelo.Hotel;
import MongoDB.simulacion.repositorio.HotelRepositorio;
import MongoDB.simulacion.utils.AlreadyExistsException;


public class HotelServicio {
	private static final Logger logger = LogManager.getLogger(HotelServicio.class);
	private HotelRepositorio repositorio;
	public HotelRepositorio getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(HotelRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	public HotelServicio(MongoDatabase db) {
		super();
		this.repositorio = new HotelRepositorio(db);
	}
	
	
	public List<Hotel> read() {
		return repositorio.read();
	}
	
	//CRUD
	public void addHotel (Hotel h) {
		try {
			repositorio.addHotel(h);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public void deleteHotel (Hotel h) {
		try {
			repositorio.deleteHotel(h);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public Hotel getHotel (String id) {
		Hotel h = null;
		try {
			h = repositorio.getHotel(id);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return h;
	}
	
	public void updateHotel (String id, Hotel h) {
		try {
			repositorio.updateUser(id, h);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public List<Hotel> filtrarXCodigoPostal () {
		List<Hotel> hoteles = repositorio.filtrarXCodigoPostal();
		return hoteles;
	}
	
	public List<Hotel> filtraXSuiteJunior () {
		return repositorio.filtrarXSuiteJunior();
	}
	
	public UpdateResult updateHabitacion (String id,Habitacion habitacion) {
		return repositorio.updateHabitacion(id, habitacion);
	}
	
	public UpdateResult updateCodigoPostal () {
		return repositorio.updateCodigoPostal();
	}
	
	public UpdateResult updateXId () {
		return repositorio.updateXId();
	}
	
	public UpdateResult pullHab() {
		return repositorio.pullHab();
	}
	
	public double calcularMediaEstrellas () {
		return repositorio.calcularMediaEstrellas();
	}
}
