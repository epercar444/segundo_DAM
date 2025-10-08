package file.primer_boletin.modelo;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.pruebas_iniciales.primera_prueba;

public class Ejercicio4 {
	private static final Logger logger = LogManager.getLogger(primera_prueba.class);

	public void getProRecursive(File padre) {
		boolean existe = padre.exists();
		if(existe && padre.isDirectory()) {
			File [] listaFicheros = padre.listFiles();
			for (File f : listaFicheros) {
				if(f.isFile()){
					logger.info(f.getName());
				}
				else {
					this.getProRecursive(f);
				}
			}
		}
		else {
			logger.info(padre.getName());
		}

		

	}
}