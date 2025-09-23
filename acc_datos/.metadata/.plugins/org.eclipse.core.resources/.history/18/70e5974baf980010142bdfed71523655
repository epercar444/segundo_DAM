package Libreria.repositorio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Libreria.modelo.Libreria_Exception;
import Libreria.modelo.Libro;

public class LibroRepo {

	private Set<Libro> libros;

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	public LibroRepo() {
		super();
		this.libros = new HashSet<Libro>();
	}
	
	
	public void addLibro (Libro l) {
		libros.add(l);
	}
	
	public boolean deleteLibro (String ISBN) throws Libreria_Exception {
		boolean esta = false;
		for (Libro l : libros) {
			while (l.getISBN().equals(ISBN)) {
				libros.remove(l);
			}
			esta = true;
		}
		if (esta = false) {
			throw new Libreria_Exception ("No existe dicho libro");
		}
		return esta;
	}
	
	public Libro consultLibro (String ISBN) throws Libreria_Exception {
		boolean encontrado = false;
		Libro p = null;
		
		Iterator<Libro> iterator = libros.iterator();
			while (!encontrado && iterator.hasNext()) {
				Libro l = iterator.next();
				if (l.getISBN().equals(ISBN)) {
					p = l; 
					encontrado = true;
			}
		}
		return p;
	}
	
	/*public boolean actualizaLibro (Libro l) throws Libreria_Exception {
		boolean esta = false;
		if (libros.contains(antiguo)) {
			libros.remove(antiguo);
			libros.add(nuevo);
			esta = true;
		}
		else {
			throw new Libreria_Exception ("No existe dicho libro");
		}
		return esta;*/
	}


