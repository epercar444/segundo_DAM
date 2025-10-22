package file.JSON.pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
	
	public void leeJson (String ruta,List<Pokemon> pokemons) {
		{// Convertir el objeto a JSON
			 Gson gson = new Gson();
			 String json = gson.toJson(pokemons);
			 FileWriter fichero = null;
			 try {
				fichero = new FileWriter(ruta);
				fichero.write(json);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fichero != null) {
					try {
						fichero.close();
					} catch (IOException e) {
						System.out.println("Error al escribir empleado");
					}			}		}	   }
	}
}
