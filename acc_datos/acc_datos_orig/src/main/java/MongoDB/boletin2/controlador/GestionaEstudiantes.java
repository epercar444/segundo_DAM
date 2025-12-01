package MongoDB.boletin2.controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import MongoDB.boletin2.servicio.EstudianteServicio;
import MongoDB.configuracion.MongoDBConexion;

public class GestionaEstudiantes {
	private static final Logger logger = LogManager.getLogger(GestionaEstudiantes.class);
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
		EstudianteServicio servicio = new EstudianteServicio(db);
		
		/*for (Estudiante e : servicio.getRepo().getEstudiantes()) {
			System.out.println(e);
		}
		System.out.println(servicio.notaInferiorA(5));*/
		servicio.scoreMedio();
	}

}
