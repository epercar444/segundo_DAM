package controlador;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Libro;
import modelo.Lector;
import modelo.Autor;
import servicio.ServicioAnotacion;
import servicio.ServicioAutor;
import servicio.ServicioEditorial;
import servicio.ServicioLector;
import servicio.ServicioLibro;

public class GestionaConsultas {
    private static final Logger logger = LogManager.getLogger(GestionaConsultas.class);
	public static void main(String[] args) {
		ServicioLibro libro = new ServicioLibro();
		ServicioLector  lector = new ServicioLector();
		ServicioAnotacion anotacion = new ServicioAnotacion();
		ServicioEditorial editorial = new ServicioEditorial();
		ServicioAutor autor = new ServicioAutor();
		
		
		//Devuelve 1 sólo libro
		logger.info(libro.getOneBook());
		
		//Un campo de una tabla
		logger.info(lector.getCampo());
		
		//Dos o más campos de una tabla
		List<Object[]> resultados = anotacion.getCampos();
		for (Object[] o : resultados) {
			logger.info(Arrays.toString(o));
		}
		
		//Consulta parametrizada uno: x numPaginas
		List<Libro> libros = libro.parametrizarUno();
		for (Libro l : libros) {
			logger.info(l);
		}
		
		//Consulta parametrizada dos: x password
		List<Lector> lectores = lector.parametrizarDos();
		for (Lector lect : lectores) {
			logger.info(lect);
		}
		
		//Consulta con count
		logger.info(editorial.countEditorial());
		
		//Consulta con avg
		logger.info(anotacion.consultaAVG());
		
		//Consulta x filtro : empieza por M mayúscula
		List<Autor> autores = autor.consultaFiltro();
		for (Autor a : autores) {
			logger.info(a);
		}
		
		//Consulta ordenada de forma ascendente
		List<Lector> lectoresOrdenados = lector.obtenerLectoresOrdenados();
		for (Lector le : lectoresOrdenados) {
			logger.info(le);
		}
		
		//UpdateCriteria
		autor.actualizarCriteria(1);
		logger.info(autor.getAutor(1));
		
		/*DeleteCriteria
		 * autor.deleteCriteria(1);
		 * logger.info(autor.getAutor(1); No va*/
	}
}
