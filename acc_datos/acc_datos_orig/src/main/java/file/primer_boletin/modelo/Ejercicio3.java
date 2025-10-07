package file.primer_boletin.modelo;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.pruebas_iniciales.primera_prueba;

public class Ejercicio3 {
	private static final Logger logger = LogManager.getLogger(primera_prueba.class);
	
	public void crearDirectorio (String ruta) throws ExceptionEjercicio1 {
		File archivo = new File(ruta);
		archivo.mkdir();
		
}
}