package modelo;

import java.util.Objects;

import utils.EstadoLibro;
import utils.GeneroLibro;

public class Libro {
	private String ISBN,titulo,autor;
	private int num_paginas;
	private boolean validado;
	private GeneroLibro genero;
	private EstadoLibro estado;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
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
	public int getNum_paginas() {
		return num_paginas;
	}
	public void setNum_paginas(int num_paginas) {
		this.num_paginas = num_paginas;
	}
	public boolean getValidado() {
		return validado;
	}
	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	public GeneroLibro getGenero() {
		return genero;
	}
	public void setGenero(GeneroLibro genero) {
		this.genero = genero;
	}
	public EstadoLibro getEstado() {
		return estado;
	}
	public void setEstado(EstadoLibro estado) {
		this.estado = estado;
	}
	public Libro(String iSBN, String titulo, String autor, int num_paginas, boolean validado, GeneroLibro genero,
			EstadoLibro estado) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.num_paginas = num_paginas;
		this.validado = validado;
		this.genero = genero;
		this.estado = estado;
	}
	public Libro() {
		super();
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
		return "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", num_paginas=" + num_paginas
				+ ", validado=" + validado + ", genero=" + genero + ", estado=" + estado + "]";
	}
	
	
}
