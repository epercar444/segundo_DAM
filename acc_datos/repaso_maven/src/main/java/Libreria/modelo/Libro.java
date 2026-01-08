package Libreria.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Libro {
	private String titulo, autor, ISBN;
	private LocalDate anyo_publicacion;
	private int num_ejem_disp;
	private Genero_Libro genero;
	private Editorial editorial;
	
	public Libro(String titulo, String autor, Editorial editorial, String iSBN, LocalDate anyo_publicacion,
			int num_ejem_disp,Genero_Libro genero) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		ISBN = iSBN;
		this.anyo_publicacion = anyo_publicacion;
		this.num_ejem_disp = num_ejem_disp;
		this.genero = genero;
	}
	
	public Genero_Libro getGenero() {
		return genero;
	}

	public void setGenero(Genero_Libro genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public LocalDate getAnyo_publicacion() {
		return anyo_publicacion;
	}
	public void setAnyo_publicacion(LocalDate anyo_publicacion) {
		this.anyo_publicacion = anyo_publicacion;
	}
	public int getNum_ejem_disp() {
		return num_ejem_disp;
	}
	public void setNum_ejem_disp(int num_ejem_disp) {
		this.num_ejem_disp = num_ejem_disp;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(ISBN, other.ISBN);
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", ISBN=" + ISBN
				+ ", anyo_publicacion=" + anyo_publicacion + ", num_ejem_disp=" + num_ejem_disp + ", genero=" + genero
				+ "]";
	}
	
	
}
