package file.pruebas_iniciales;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class primera_prueba {
	private static final Logger logger = LogManager.getLogger(primera_prueba.class);
	public static void main(String[] args) {
	String rutaDirectorio = "C:\\Users\\alumno\\Desktop\\prueba";
	File directorio = new File(rutaDirectorio);
	// Referencio a un fichero dentro del directorio escritorio
	//File fichero = new File(rutaDirectorio, "fichero1.txt");
	File directorio1 = new File(rutaDirectorio);
	boolean creado = directorio1.mkdir(); // Aquí Sí creo fichero
}
	
	
}
