package Libreria.repositorio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Libreria.modelo.Libreria_Exception;
import Libreria.modelo.Libro;

public class LibroRepo {

	private List<Libro> libros;

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public LibroRepo() {
		super();
		this.libros = new ArrayList<Libro>();
	}
	
	
	public void addLibro (Libro l) {
		libros.add(l);
	}
	
	public boolean deleteLibro (String ISBN) throws Libreria_Exception {
		boolean esta = true;
		Libro l = leeLibro(ISBN);
		if (l==null) {
			esta= false;
			throw new Libreria_Exception ("El libro indicado no existe");
		}
		else {
			libros.remove(l);
		}
		return esta;
	}
	
	public Libro leeLibro (String ISBN) throws Libreria_Exception {
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
	
	public boolean actualizaLibro (Libro l1) throws Libreria_Exception {
		boolean esta = true;
		Libro l = leeLibro(l1.getISBN());
		if (l == null) {
			esta= false;
			throw new Libreria_Exception ("El libro indicado no existe");
		}
		else {
			libros.remove(l);
			libros.add(l1);
		}
		return esta;
	}
	
	public boolean consultaLibro (String ISBN) throws Libreria_Exception {
		boolean esta = true;
		Libro l = leeLibro(ISBN);
		if (l ==null) {
			esta= false;
			throw new Libreria_Exception ("La editorial indicada no existe");
		}
		else {
			System.out.println(l.toString());
		}
		return esta;
	}
}


