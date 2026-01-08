package Libreria.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import Libreria.comparator.Comparator;
import Libreria.modelo.Editorial;
import Libreria.modelo.Libreria_Exception;
import Libreria.modelo.Libro;
import Libreria.repositorio.EditorialRepo;
import Libreria.repositorio.LibroRepo;

public class EditorialServicio {
	EditorialRepo repo = new EditorialRepo();
	LibroRepo repo1 = new LibroRepo();
	
	public EditorialRepo getRepo() {
		return repo;
	}

	public void setRepo(EditorialRepo repo) {
		this.repo = repo;
	}

	public LibroRepo getRepo1() {
		return repo1;
	}

	public void setRepo1(LibroRepo repo1) {
		this.repo1 = repo1;
	}

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
	
	/*public Set<Editorial> getEditorialOrdenada () {
		Set<Editorial> editoriales_ordenadas_1 = new TreeSet<>();
		for (Editorial e : repo.getEditoriales()) {
			editoriales_ordenadas_1.add(e);
		}
		return editoriales_ordenadas_1;
	}
	ya se ordena*/
	
	public List<Editorial> ordenaEditorialPorEmail() {
		Comparator y = new Comparator();
		List <Editorial > editorialesOrd = repo.getEditoriales();
		editorialesOrd.sort(y); //void
		return editorialesOrd;
	    //hacer método q devuelva numlibros por editorial
	    

}
}
