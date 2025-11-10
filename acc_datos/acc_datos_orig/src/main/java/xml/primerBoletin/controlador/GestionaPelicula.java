package xml.primerBoletin.controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.primerBoletin.DOM.domPelicula;
import xml.primerBoletin.modelo.Actor;
import xml.primerBoletin.modelo.Pelicula;
import xml.primerBoletin.service.PeliculaServ;


public class GestionaPelicula {
	private static final Logger logger = LogManager.getLogger(GestionaPelicula.class);
	public static void main(String[] args) {
		domPelicula dom = new domPelicula();
		List<Pelicula> peliculas = new ArrayList<>();
		try {
			peliculas = dom.leerPeliculasDesdeXML("peliculas.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PeliculaServ ps = new PeliculaServ(peliculas);
		Actor actor1 = new Actor("Eva Pérez"); //prueba
		Actor actor2 = new Actor("Geraldine Hughes");
		Actor actor3 = new Actor("John Carroll Lynch");
		List<Actor> actoresGranTorino = new ArrayList<>();
		actoresGranTorino.add(actor1);
		actoresGranTorino.add(actor2);
		actoresGranTorino.add(actor3);
		Pelicula granTorino = new Pelicula("Gran Torino", "Wachowski Brothers", 1999, actoresGranTorino);

		Actor actorA = new Actor("Emma Stone");
		Actor actorB = new Actor("Ryan Gosling");
		List<Actor> actoresAleatoria = new ArrayList<>();
		actoresAleatoria.add(actorA);
		actoresAleatoria.add(actorB);
		Pelicula peliculaAleatoria = new Pelicula("Luz de Medianoche", "Christopher Nolan", 2023, actoresAleatoria);
		try {
			//add : bien 
			//ps.addPelicula(peliculaAleatoria);
			//ps.addPelicula(granTorino);
			//logger.info(ps.getRepositorio().getPeliculas());

			
			//delete : bien
			//ps.deletePelicula(granTorino); 
			//ps.deletePelicula(peliculaAleatoria);
			//logger.info(ps.getRepositorio().getPeliculas());
			
			
			//actualiza : bien
			//ps.updatePelicula(granTorino);
			//ps.updatePelicula(peliculaAleatoria);
			//logger.info(ps.getRepositorio().getPeliculas());
			
			//read : bien
			//ps.readPelicula(granTorino);
			//ps.readPelicula(peliculaAleatoria);
			
			//readFromXML : bien
			//logger.info(ps.leerPeliculasDesdeXML("peliculas.xml"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
