package file.JSON.pokemon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UtilidadesPokemonCsv {
	public void CreaFicheroCsv (String ruta) throws IOException {
		PrintWriter out = null;
		File ruta_real = new File(ruta);
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta_real);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			out.printf("id,nombre,tipo,altura_m,peso_kg,habilidades,evoluciona_a\r\n"
					+ "1,Bulbasaur,\"Planta;Veneno\",0.7,6.9,\"Espesura;Clorofila\",Ivysaur\r\n");
			}		
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}
		
}
