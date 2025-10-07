package file.primer_boletin.modelo;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.pruebas_iniciales.primera_prueba;

public class Ejercicio1 {
	private static final Logger logger = LogManager.getLogger(primera_prueba.class);
	
	public void listDirectorio (String ruta) throws ExceptionEjercicio1 {
		File archivo = new File(ruta);
		if (archivo.exists() && archivo.isDirectory()) {
			String [] archivos_ruta = archivo.list();
			for (String f : archivos_ruta) {
				logger.info(f);
			}
		}
		else {
			throw new ExceptionEjercicio1 ("La ruta indicada no existe");
		}
		
	}
	
}
