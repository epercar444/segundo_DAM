package file.primer_boletin.modelo;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.pruebas_iniciales.primera_prueba;

public class Ejercicio2 {
	private static final Logger logger = LogManager.getLogger(primera_prueba.class);
	
	public void propiedadesDirectorio (String ruta) throws ExceptionEjercicio1 {
		File archivo = new File(ruta);
		if (archivo.exists() && archivo.isDirectory()) {
			logger.info(archivo.getName());
			logger.info(archivo.getPath());
			logger.info(archivo.getAbsolutePath());
			logger.info(archivo.length());
			logger.info(archivo.lastModified());
			logger.info(archivo.isDirectory());
			logger.info(archivo.getParent());
			try {
				logger.info(archivo.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.info(e.getMessage());
			}
			}
		else {
			throw new ExceptionEjercicio1 ("La ruta indicada no existe");
		}
		
	}
}
