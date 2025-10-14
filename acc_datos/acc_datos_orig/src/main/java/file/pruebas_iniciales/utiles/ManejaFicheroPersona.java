package file.pruebas_iniciales.utiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.pruebas_iniciales.Persona;
import file.pruebas_iniciales.gestionaFicheros;

public class ManejaFicheroPersona {
	private static final Logger logger = LogManager.getLogger(gestionaFicheros.class);
	public void muestraContenidoFich(String rutaYNombre) throws FileNotFoundException {
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			//Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { //Lectura palabra a palabra
				// Aquí se hará la lectura in.next()
				String linea = in.nextLine();
				Persona p = cargaPersona(linea);
				logger.info(p.toString());
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
	public Persona cargaPersona(String linea) {
		String[] cadenas = linea.split(" ");
		List<Double> lista = new ArrayList<>();
		for (int i = 1; i < cadenas.length; i++) {
			Double n = Double.parseDouble(cadenas[i]);
			lista.add(n);
		}
		Persona p = new Persona(cadenas[0], lista);
		return p;


}
}
