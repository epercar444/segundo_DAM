package file.segundo_boletin.Ejercicio1SinMVC;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.primer_boletin.controlador.PrimerBoletin_main;

public class ControladorDiff {
	private static final Logger logger = LogManager.getLogger(PrimerBoletin_main.class);

	public static void main(String[] args) {
		String directorioGeneralCasa1 = "C:\\Users\\evape\\Onedrive\\Escritorio\\segundo_DAM";
		String directorioGeneralCasa2 = "C:\\Users\\evape\\Onedrive\\Escritorio\\DAM";
		File folder1 = new File(directorioGeneralCasa1);
		File folder2 = new File(directorioGeneralCasa2);
		DiffFolder df = new DiffFolder(folder1, folder2);
		try {
			logger.info("Contador ficheros: " + df.getNumFicheroPorDirectorio(folder1, folder2));
		} catch (GestionFicherosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
