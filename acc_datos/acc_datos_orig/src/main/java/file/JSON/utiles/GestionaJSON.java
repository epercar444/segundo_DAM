package file.JSON.utiles;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import file.JSON.primerasPruebas.Empleado;
import file.pruebas_iniciales.gestionaFicheros;

public class GestionaJSON {
	public static void main(String[] args) {
		GestionaJSON g = new GestionaJSON();
		String ruta_fichero = "src/main/resources/Empleado.json";
		File ruta = new File(ruta_fichero);
		g.leeEmpleados(ruta);
	}
	private static final Logger logger = LogManager.getLogger(GestionaJSON.class);
	public void leeEmpleados(File rutaFichero) {
		try {
		  Gson gson = new Gson();
		  FileReader fichero = new FileReader(rutaFichero);
		  // Leer el archivo JSON y convertirlo a un objeto Empleado
		  Empleado empleadosArray = gson.fromJson(fichero,Empleado.class);
		  logger.debug(empleadosArray);
		} catch (Exception e) {
			System.out.println("Error al leer empleados"+e.getMessage());
		}	}

}
