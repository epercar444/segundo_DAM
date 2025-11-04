package xml.primerBoletin.controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.primerBoletin.DOM.domPelicula;
import xml.primerBoletin.modelo.Pelicula;


public class GestionaPelicula {
	private static final Logger logger = LogManager.getLogger(GestionaPelicula.class);
	public static void main(String[] args) {
		domPelicula pel = new domPelicula();
		try {
			List<Pelicula> pelicula = pel.leerPeliculasDesdeXML("peliculas.xml");
			logger.info(pelicula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
