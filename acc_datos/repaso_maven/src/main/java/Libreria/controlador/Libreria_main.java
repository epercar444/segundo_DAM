package Libreria.controlador;

import java.time.LocalDate;

import Libreria.modelo.Genero_Libro;
import Libreria.modelo.Libreria_Exception;
import Libreria.modelo.Libro;
import Libreria.repositorio.*;

public class Libreria_main {

	public static void main(String[] args) {
		LibroRepo n = new LibroRepo();
		Libro miLibro = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "Editorial Sudamericana", "978-3-16-148410-0", LocalDate.of(1967, 5, 30), 5, Genero_Libro.TERROR);
		try {
			n.addLibro(miLibro);
			System.out.println(n.consultLibro("978-3-16-148410-0"));
		} catch (Libreria_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
