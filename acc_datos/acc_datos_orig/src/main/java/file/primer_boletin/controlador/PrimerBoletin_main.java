package file.primer_boletin.controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.primer_boletin.modelo.Ejercicio1;
import file.primer_boletin.modelo.Ejercicio2;
import file.primer_boletin.modelo.ExceptionEjercicio1;

public class PrimerBoletin_main {
	private static final Logger logger = LogManager.getLogger(PrimerBoletin_main.class);

	public static void main(String[] args) {
		String directorioGeneralCasa = "C:\\Users\\evape\\Onedrive\\Escritorio";
		String directorioGeneralCasaInventado = "C:\\Users\\evape\\Onedrive\\Escritorio\\inventado";
		Ejercicio1 primer_ejercicio = new Ejercicio1();
		Ejercicio2 segundo_ejercicio = new Ejercicio2();
		
		try {
			primer_ejercicio.listDirectorio(directorioGeneralCasa);
			segundo_ejercicio.propiedadesDirectorio(directorioGeneralCasa);
			primer_ejercicio.listDirectorio(directorioGeneralCasaInventado);
		} catch (ExceptionEjercicio1 e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		
		


	}

}
