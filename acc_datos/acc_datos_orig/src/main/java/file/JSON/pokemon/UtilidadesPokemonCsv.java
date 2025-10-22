package file.JSON.pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.google.gson.Gson;

public class UtilidadesPokemonCsv {
	public void CreaFicheroCsv (String ruta,Pokemon p) throws IOException {
		PrintWriter out = null;
		File ruta_real = new File(ruta);
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta_real);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			String habilidadesConcatenadas = String.join(";", p.getHabilidadPrincipal());

			out.printf(Locale.US, "Id, Nombre,Tipo, Altura, Peso, habilidadPrincipal,evoluciona_a\n" +
			    "%d,%s,%s,%f,%f,%s,%s",
			    p.getId(),
			    p.getNombre(),
			    p.getTipo(),
			    p.getAltura_m(),
			    p.getPeso_kg(),
			    habilidadesConcatenadas,
			    p.getEvoluciona_a()
			); }	
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}
		
	public List<Pokemon> leeCSV (String ruta) throws FileNotFoundException {
		List<Pokemon> pokemons = new ArrayList<>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			in.nextLine();
			while (in.hasNextLine()) { 
				String linea = in.nextLine();
				String[] linea_split = linea.split(",");
				if (linea!=null && !pokemons.contains(linea)) {
					int id = Integer.parseInt(linea_split[0]);
					String nombre = linea_split[1];
					String tipo = linea_split[2];
					float altura_m = Float.parseFloat(linea_split[3]);
					float peso_kg = Float.parseFloat(linea_split[4]);
					String[] habilidadPrincipal = linea_split[5].split(";");
					String evoluciona_a = linea_split[6];
					Pokemon p = new Pokemon(id, nombre, tipo, evoluciona_a, habilidadPrincipal, altura_m, peso_kg);
					pokemons.add(p);
					}
				}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return pokemons;
	}
}
