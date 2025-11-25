package MongoDB.controlador;

import java.util.List;

import com.mongodb.client.MongoDatabase;

import MongoDB.configuracion.MongoDBConexion;
import MongoDB.modelo.Estudiante;
import MongoDB.servicio.EstudianteService;

public class GestionaPeliculasDB {
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
		EstudianteService estduiantes = new EstudianteService(db);
		
		Estudiante estudiante1 = new Estudiante(22, "Maria Peláez", 7.78, List.of("leer","nadar"));
		estduiantes.save(estudiante1);
		List<Estudiante> estudiantesRead = estduiantes.read();
		for (Estudiante e : estudiantesRead) {
			System.out.println(e);
		}
//TODO Aquí creamos los diferentes servicios a partir del objeto db	
	}
}

