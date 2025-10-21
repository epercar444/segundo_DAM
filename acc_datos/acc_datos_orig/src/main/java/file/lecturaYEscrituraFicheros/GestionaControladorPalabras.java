package file.lecturaYEscrituraFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.pruebas_iniciales.gestionaFicheros;

public class GestionaControladorPalabras {
	private static final Logger logger = LogManager.getLogger(gestionaFicheros.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContadorPalabras clase = new ContadorPalabras();
		String ruta_fichero = "src/main/resources/fichero.txt";
		File ruta = new File(ruta_fichero);
		String ruta_fichero1 = "src/main/resources/Es.txt";
		File ruta1 = new File(ruta_fichero1);
		try {
			int num_veces = clase.ContadorPalabras("es", ruta);
			logger.info("Número de veces: "+num_veces);
			clase.CreaFicheroEs(num_veces,ruta1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
