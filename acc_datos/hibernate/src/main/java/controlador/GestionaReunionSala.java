package controlador;

import java.time.LocalDateTime;

import modelo.Reunion;
import modelo.Sala;
import repositorio.RepositorioReunion;
import repositorio.RepositorioSala;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestionaReunionSala {
	private static final Logger logger = LogManager.getLogger(GestionaReunionSala.class);
	public static void main(String[] args) {
		RepositorioReunion repo = new RepositorioReunion();
		
		RepositorioSala repoSala = new RepositorioSala(); 
		Sala sala = new Sala(10, "Sala 1");
		Sala sala2 = new Sala(15, "Sala 2");
		repoSala.create(sala2);
		logger.info(repoSala.getAll());
		
		//Reunion reunion = new Reunion(LocalDateTime.now(), "He añadido esto desde el controlador");
		Reunion reunionNueva = new Reunion(LocalDateTime.now(), "Segunda reunión desde el controlador",sala2);
		/*repo.create(reunionNueva);*/
		logger.info(repo.getAll());
		
		sala2.anadirReunion(reunionNueva);
		

	}

}
