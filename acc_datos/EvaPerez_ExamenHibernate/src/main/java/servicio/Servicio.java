package servicio;

import modelo.Cine;
import modelo.Pelicula;
import modelo.Sala;
import repositorio.RepositorioCine;
import repositorio.RepositorioPelicula;
import repositorio.RepositorioSala;

public class Servicio {
	RepositorioCine repositorioCine;
	RepositorioPelicula repositorioPelicula;
	RepositorioSala repositorioSala;
	
	public RepositorioCine getRepositorioCine() {
		return repositorioCine;
	}
	public void setRepositorioCine(RepositorioCine repositorioCine) {
		this.repositorioCine = repositorioCine;
	}
	public RepositorioPelicula getRepositorioPelicula() {
		return repositorioPelicula;
	}
	public void setRepositorioPelicula(RepositorioPelicula repositorioPelicula) {
		this.repositorioPelicula = repositorioPelicula;
	}
	public RepositorioSala getRepositorioSala() {
		return repositorioSala;
	}
	public void setRepositorioSala(RepositorioSala repositorioSala) {
		this.repositorioSala = repositorioSala;
	}
	public Servicio() {
		super();
		this.repositorioCine = new RepositorioCine();
		this.repositorioPelicula = new RepositorioPelicula();
		this.repositorioSala = new RepositorioSala();
	}
	
	//Crud Cine
	public void addCine (Cine c) {
		repositorioCine.create(c);
	}
	
	public void deleteCine (Cine c) {
		repositorioCine.delete(c);
	}
	
	public Cine getCine (int id) {
		return repositorioCine.get(id);
	}
	
	public void updateCine (Cine c) {
		repositorioCine.update(c);
	}
	
	//Crud Pelicula
	public void addPelicula (Pelicula p) {
		repositorioPelicula.create(p);
	}
	
	public void deletePelicula (Pelicula p) {
		repositorioPelicula.delete(p);
	}
	
	public Pelicula getPelicula (int id) {
		return repositorioPelicula.get(id);
	}
	
	public void updatePelicula (Pelicula p) {
		repositorioPelicula.update(p);
	}
	
	//Crud Sala
	public void addSala (Sala s) {
		repositorioSala.create(s);
	}
	
	public void deleteSala (Sala s) {
		repositorioSala.delete(s);
	}
	
	public Sala getSala (int id) {
		return repositorioSala.get(id);
	}
	
	public void updateSala (Sala s) {
		repositorioSala.update(s);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
