package file.JSON.pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

public class UtilidadesJsonPokemons {
	private static final Logger logger = LogManager.getLogger(UtilidadesJsonPokemons.class); //pasa algo si no es de tu tipo?
	public Pokemon leePokemon(String ruta) throws FileNotFoundException {
		File ruta_real = new File(ruta);
		Gson gson = new Gson();
		FileReader fichero = new FileReader(ruta_real);
		Pokemon pokemonsArray = gson.fromJson(fichero,Pokemon.class);
		return pokemonsArray;
		
	}
}
