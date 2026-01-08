package file.pruebas_iniciales;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.pruebas_iniciales.utiles.*;


public class gestionaFicheros {
	private static final Logger logger = LogManager.getLogger(gestionaFicheros.class);
	public static void main(String[] args) {
	String directorioGeneralClase1 = "src\\main\\resources\\persona.txt";
	ManejaFicheroPersona u = new ManejaFicheroPersona();
	try {
		u.muestraContenidoFich(directorioGeneralClase1);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
