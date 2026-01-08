package file.segundo_boletin.Paises;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.pruebas_iniciales.gestionaFicheros;
import file.segundo_boletin.Paises.utiles.GestionaFicherosPaises;

public class GestionaPaises {
	private static final Logger logger = LogManager.getLogger(GestionaPaises.class);
	public static void main(String[] args) {
		String ruta_fichero = "src/main/resources/paises.csv";
		GestionaFicherosPaises clase = new GestionaFicherosPaises();
		try {
			logger.debug(clase.ListaPaises(ruta_fichero));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
