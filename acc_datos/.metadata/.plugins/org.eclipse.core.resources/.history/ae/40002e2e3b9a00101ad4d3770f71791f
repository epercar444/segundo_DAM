package Libreria.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import Libreria.modelo.Editorial;
import Libreria.modelo.Libreria_Exception;
import Libreria.modelo.Libro;
import Libreria.repositorio.EditorialRepo;
import Libreria.repositorio.LibroRepo;

public class EditorialServicio {
	EditorialRepo repo = new EditorialRepo();
	LibroRepo repo1 = new LibroRepo();
	
	public void leeEditorial (String CIF) {
		try {
			repo.leeEditorial(CIF);
		} catch (Libreria_Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void addEditorial (Editorial e) {
		repo.addEditorial(e);
	}
	
	public void deleteEditorial (String CIF) {
		try {
			repo.deleteEditorial(CIF);
		} catch (Libreria_Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void actualizaEditorial (Editorial e1, String ISBN) {
		try {
			repo.actualizaEditorial(ISBN, e1);
		} catch (Libreria_Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void consultaEditorial (String CIF) {
		try {
			repo.consultaEditorial(CIF);
		} catch (Libreria_Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public Set<Editorial> getEditorialOrdenada () {
		Set<Editorial> editoriales_ordenadas_1 = new TreeSet<>();
		for (Editorial e : repo.getEditoriales()) {
			editoriales_ordenadas_1.add(e);
		}
		return editoriales_ordenadas_1;
	}
	
	public List<Map<Editorial, Integer>> contarYOrdenarLibros(List<Libro> libros) {
	    Map<Editorial, Integer> editoriales_por_libro = new HashMap<>();
	    for (Libro libro : repo1.getLibros()) {
	        Editorial e = libro.getEditorial();
	        if (editoriales_por_libro.containsKey(e)) {
	            editoriales_por_libro.put(e, editoriales_por_libro.get(e) + 1);
	        } else {
	            editoriales_por_libro.put(e, 1);
	        }
	    }
		return null;
	}
}
