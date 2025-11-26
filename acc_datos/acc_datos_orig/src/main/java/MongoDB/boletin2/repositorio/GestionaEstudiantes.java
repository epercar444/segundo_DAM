package MongoDB.boletin2.repositorio;

import com.mongodb.client.MongoDatabase;

import MongoDB.boletin2.modelo.Estudiante;
import MongoDB.configuracion.MongoDBConexion;

public class GestionaEstudiantes {

	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
		EstudianteRepositorio repo = new EstudianteRepositorio(db);
		
		for (Estudiante e : repo.getEstudiantes()) {
			System.out.println(e);
		}

	}

}
