package file.primer_boletin.modelo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.pruebas_iniciales.primera_prueba;

public class Ejercicio3 {
	private static final Logger logger = LogManager.getLogger(primera_prueba.class);
	
	public void crearDirectorio (String ruta,String nombre_directorio) throws ExceptionEjercicio1, IOException {
		File miDirectorio = new File(ruta + "\\" + nombre_directorio);
		boolean creado = miDirectorio.mkdir();
		File fichero1 = new File(miDirectorio, "fichero_prueba1");
		boolean creado2 = fichero1.createNewFile();
		File fichero2 = new File(miDirectorio, "fichero_pruebas");
		boolean creado3 = fichero2.createNewFile();
		boolean lectura = fichero2.setReadOnly();
		//boolean lectura1 = fichero2.setReadable(true);
		logger.info(fichero2.canRead());
}
}