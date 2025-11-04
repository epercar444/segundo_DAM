package xml.primerBoletin.modelo;

import java.util.List;

public class Pelicula {
	private String titulo,director;
	private int fecha;
	private List<Actor> actores;
	
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public List<Actor> getActores() {
		return actores;
	}
	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getAnyo() {
		return fecha;
	}
	public void setAnyo(int anyo) {
		this.fecha = anyo;
	}
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", director=" + director + ", fecha=" + fecha + ", actores=" + actores
				+ "]";
	}
	
}
