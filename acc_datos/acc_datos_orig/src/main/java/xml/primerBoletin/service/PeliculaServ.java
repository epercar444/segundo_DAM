package xml.primerBoletin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xml.primerBoletin.DOM.domPelicula;
import xml.primerBoletin.exceptions.NotAddException;
import xml.primerBoletin.modelo.Pelicula;
import xml.primerBoletin.repositorio.PeliculaRepo;

public class PeliculaServ {
    private static final Logger logger = LogManager.getLogger(PeliculaServ.class);
	private domPelicula dom;
	private PeliculaRepo repositorio;
	
	
	public PeliculaServ(List<Pelicula> peliculas) {
		super();
		this.dom = new domPelicula();
		this.repositorio = new PeliculaRepo(peliculas);
	}

	public PeliculaRepo getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(PeliculaRepo repositorio) {
		this.repositorio = repositorio;
	}

	
	public void addPelicula (Pelicula p) {
		try {
			repositorio.addPelicula(p);
		} catch (NotAddException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public void deletePelicula (Pelicula p) {
		try {
			repositorio.deletePelicula(p);
		} catch (NotAddException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public void updatePelicula (Pelicula p) {
		try {
			repositorio.updatePelicula(p);
		} catch (NotAddException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public void readPelicula (Pelicula p) {
		try {
			repositorio.readPelicula(p);
		} catch (NotAddException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public List<Pelicula> leerPeliculasDesdeXML(String rutaFichero) {
		List<Pelicula> peliculas = new ArrayList<>();
		try {
			peliculas = dom.leerPeliculasDesdeXML(rutaFichero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return peliculas;
	}
}
