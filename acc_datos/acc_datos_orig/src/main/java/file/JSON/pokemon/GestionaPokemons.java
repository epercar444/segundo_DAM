package file.JSON.pokemon;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestionaPokemons {
	private static final Logger logger = LogManager.getLogger(GestionaPokemons.class);
	public static void main(String[] args) {
		UtilidadesJsonPokemons clase = new UtilidadesJsonPokemons();
		UtilidadesPokemonCsv clase1 = new UtilidadesPokemonCsv();
		String ruta_fichero = "src/main/resources/Pokemon.json";
		String ruta_fichero1 = "src/main/resources/Pokemon.csv";
		try {
			logger.debug(clase.leePokemon(ruta_fichero));
			clase1.CreaFicheroCsv(ruta_fichero1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
