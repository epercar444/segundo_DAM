package Libreria.controlador;

import java.time.LocalDate;

import Libreria.modelo.Editorial;
import Libreria.modelo.Genero_Libro;
import Libreria.modelo.Libreria_Exception;
import Libreria.modelo.Libro;
import Libreria.repositorio.*;
import Libreria.servicios.EditorialServicio;
import Libreria.servicios.LibroServicio;

public class Libreria_main {

	public static void main(String[] args) {
		EditorialServicio serv_edi = new EditorialServicio();
		LibroServicio serv_li = new LibroServicio();
		Editorial editorial1 = new Editorial("Planeta", "Calle Falsa 123", "A12345678", "www.planeta.com", "info@planeta.com");
		Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", editorial1, "ISBN654321", LocalDate.of(1967, 5, 30), 7, Genero_Libro.INFANTIL);
		Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", editorial1, "ISBN123456", LocalDate.of(1605, 1, 16), 10, Genero_Libro.HISTÓRICO);
		Libro libro_actu = new Libro("El Quijote y Sancho Panza", "Miguel de Cervantes", editorial1, "ISBN123456", LocalDate.of(1605, 1, 16), 10, Genero_Libro.HISTÓRICO);
		Libro libro3 = new Libro("Los pilares de la Tierra", "Ken Follett", editorial1, "ISBN987654", LocalDate.of(1989, 9, 1), 5, Genero_Libro.HISTÓRICO);
		
		System.out.println("Añadir libro: ");
		serv_li.addLibro(libro1);
		serv_li.addLibro(libro2);
		serv_li.addLibro(libro3);
		System.out.println(serv_li.getRepo().getLibros());
		
		System.out.println("Borrar libro: ");
		serv_li.deleteLibro("ISBN654321");
		System.out.println(serv_li.getRepo().getLibros());
		
		System.out.println("Consultar libro:");
		serv_li.consultaLibro("ISBN123456");
		serv_li.consultaLibro("ISBN654321");
		
		System.out.println("Actualiza libro:");
		serv_li.actualizaLibro(libro_actu);
		serv_li.actualizaLibro(libro2);
		serv_li.consultaLibro("ISBN123456");
		
		System.out.println("Busca por género: ");
		System.out.println(serv_li.getPorGenero(Genero_Libro.HISTÓRICO));
		
		System.out.println("Busca por CIF: ");
		System.out.println(serv_li.getPorCIF("A12345678"));
		
		System.out.println("Mapa: ");
		System.out.println(serv_li.getMapaPorGenero(Genero_Libro.HISTÓRICO));
		
	}
	
}





