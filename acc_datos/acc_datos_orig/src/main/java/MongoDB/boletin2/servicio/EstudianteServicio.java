package MongoDB.boletin2.servicio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import MongoDB.boletin2.modelo.Estudiante;
import MongoDB.boletin2.modelo.Scores;
import MongoDB.boletin2.repositorio.EstudianteRepositorio;
import MongoDB.boletin2.utils.AlreadyExistsException;

public class EstudianteServicio {
	private static final Logger logger = LogManager.getLogger(EstudianteServicio.class);
	private EstudianteRepositorio repo;

	public EstudianteServicio(MongoDatabase db) {
		super();
		this.repo = new EstudianteRepositorio(db);
	}
	
	

	public EstudianteRepositorio getRepo() {
		return repo;
	}
	public void setRepo(EstudianteRepositorio repo) {
		this.repo = repo;
	}



	//CRUD
	public void addEstudiante (Estudiante e) {
		try {
			repo.addEstudiante(e);
		} catch (AlreadyExistsException e1) {
			// TODO Auto-generated catch block
			logger.info(e1.getMessage());
		}
	}
	
	public void deleteEstudiante (int id) {
		try {
			repo.deleteEstudiante(id);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public Estudiante getEstudiante (int id) {
		Estudiante e = null;
		try {
			e = repo.getEstudiante(id);
		} catch (AlreadyExistsException e1) {
			// TODO Auto-generated catch block
			logger.info(e1.getMessage());
		}
		return e;
	}
	
	
	public void updateEstudiante (int id,Estudiante e) {
		try {
			repo.updateEstudiante(id, e);
		} catch (AlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public List<Estudiante> read () {
		List<Estudiante> estudiantes = repo.read();
		return estudiantes;
	}
	
	public List<Estudiante> notaInferiorA (int numero) {
		List<Estudiante> inferioresA = new ArrayList<>();
		for (Estudiante e : repo.getEstudiantes()) {
			if (e.getNotaMedia() < numero) {
				inferioresA.add(e);
			}
		}
		return inferioresA;
	}
	
	public void scoreMedio() {
	    for (Estudiante e : repo.getEstudiantes()) {
	        List<Scores> scores = e.getNotas();
	        double sumaScore = 0; 
	        for (Scores s : scores) {
	            sumaScore += s.getScore();
	        }
	        double media = sumaScore / scores.size();
	        System.out.println(e.getName() + " con media: " + media);
	    }
	}

	
}
