package Libreria.repositorio;

import java.util.HashSet;
import java.util.Set;

import Libreria.modelo.Editorial;
import Libreria.modelo.Libreria_Exception;

public class EditorialRepo {
	private Set<Editorial> editoriales;

	public Set<Editorial> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(Set<Editorial> editoriales) {
		this.editoriales = editoriales;
	}

	public EditorialRepo() {
		super();
		this.editoriales = new HashSet<Editorial>();
	}
	
	
	public void addLibro (Editorial e) {
		editoriales.add(e);
	}
	
	public boolean deleteLibro (Editorial e) throws Libreria_Exception {
		boolean esta = false;
		if (editoriales.contains(e)) {
			editoriales.remove(e);
			esta = true;
		}
		else {
			throw new Libreria_Exception ("No existe dicha editorial");
		}
		return esta;
	}
	
	public boolean consultLibro (Editorial e) throws Libreria_Exception {
		boolean esta = false;
		if (editoriales.contains(e)) {
			System.out.println(e.toString());
			esta = true;
		}
		else {
			throw new Libreria_Exception ("No existe dicha editorial");
		}
		return esta;
	}
	
	public boolean actualizaLibro (Editorial antigua, Editorial nueva) throws Libreria_Exception {
		boolean esta = false;
		if (editoriales.contains(antigua)) {
			editoriales.remove(antigua);
			editoriales.add(nueva);
			esta = true;
		}
		else {
			throw new Libreria_Exception ("No existe dicha editorial");
		}
		return esta;
	}
}
