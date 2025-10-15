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
		String directorioGeneralClase1 = "C:\\Users\\alumno\\Desktop\\segundo_DAM";
		String directorioGeneralClase2 = "C:\\Users\\alumno\\Desktop\\primero_DAM";
		File folder1 = new File(directorioGeneralCasa1);
		File folder2 = new File(directorioGeneralCasa2);
		File folder3 = new File(directorioGeneralClase1);
		File folder4 = new File(directorioGeneralClase2);
		DiffFolder df = new DiffFolder(folder1, folder1);
		try {
			//logger.info("Contador ficheros: " + df.getNumFicheroPorDirectorio(folder1, folder2));
			df.compare();
		} catch (GestionFicherosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
