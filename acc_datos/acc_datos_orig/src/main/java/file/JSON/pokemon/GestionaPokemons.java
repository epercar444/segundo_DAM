package file.JSON.pokemon;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestionaPokemons {
	private static final Logger logger = LogManager.getLogger(GestionaPokemons.class);
	public static void main(String[] args) {
		String [] habilidades = {"Espesura","Clorofila"};
		Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", "Planta;Veneno", "Ivysaur", new String[]{"Espesura", "Clorofila"}, 0.7f, 6.9f);
		UtilidadesJsonPokemons clase = new UtilidadesJsonPokemons();
		UtilidadesPokemonCsv clase1 = new UtilidadesPokemonCsv();
		String ruta_fichero = "src/main/resources/pokemons1.json";
		String ruta_fichero1 = "src/main/resources/pokemons1.csv";
		try {
			//logger.debug(clase.leePokemon(ruta_fichero));
			//clase1.CreaFicheroCsv(ruta_fichero1,bulbasaur);
			logger.debug(clase1.leeCSV(ruta_fichero1));
			List<Pokemon> pokemons = clase1.leeCSV(ruta_fichero1);
			clase.leeJson(ruta_fichero, pokemons );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
