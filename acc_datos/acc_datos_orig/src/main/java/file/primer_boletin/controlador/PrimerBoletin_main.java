package file.primer_boletin.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.primer_boletin.modelo.Ejercicio1;
import file.primer_boletin.modelo.Ejercicio2;
import file.primer_boletin.modelo.Ejercicio3;
import file.primer_boletin.modelo.Ejercicio4;
import file.primer_boletin.modelo.ExceptionEjercicio1;

public class PrimerBoletin_main {
	private static final Logger logger = LogManager.getLogger(PrimerBoletin_main.class);

	public static void main(String[] args) {
		String directorioGeneralClase = "C:\\Users\\alumno\\Desktop";
		String directorioInventadoClase = "C:\\Users\\alumno\\Desktop\\inventado";
		String directorioGeneralCasa = "C:\\Users\\evape\\Onedrive\\Escritorio\\hola";
		String directorioGeneralCasaInventado = "C:\\Users\\evape\\Onedrive\\Escritorio\\inventado";
		Ejercicio1 primer_ejercicio = new Ejercicio1();
		Ejercicio2 segundo_ejercicio = new Ejercicio2();
		Ejercicio3 tercer_ejercicio = new Ejercicio3(); 
		Ejercicio4 cuarto_ejercicio = new Ejercicio4();
		File fichero = new File(directorioGeneralCasa);
		File fichero1 = new File(directorioGeneralClase);
		cuarto_ejercicio.getProRecursive(fichero1);
		cuarto_ejercicio.getProRecursive(fichero);

		
		/*try {
			primer_ejercicio.listDirectorio(directorioGeneralClase);
			segundo_ejercicio.getPropiedadesDirectorio(directorioGeneralClase);
			tercer_ejercicio.crearDirectorio(directorioGeneralClase,"prueba");
			primer_ejercicio.listDirectorio(directorioInventadoClase);
		} catch (ExceptionEjercicio1 e) {
			//TODO Auto-generated catch block
			logger.info(e.getMessage());
		} catch (FileNotFoundException e) {
			 //TODO Auto-generated catch block
			logger.info(e.getMessage());
		} catch (IOException e) {
			 //TODO Auto-generated catch block
			logger.info(e.getMessage());
		}*/
		
		


	}

}
