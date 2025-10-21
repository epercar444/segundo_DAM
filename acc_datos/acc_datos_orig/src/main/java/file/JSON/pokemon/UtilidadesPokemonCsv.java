package file.JSON.pokemon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
			out.printf(
				    "id,nombre,tipo,altura_m,peso_kg,habilidades,evoluciona_a\r\n" +
				    "%d,%s,\"%s\",%.1f,%.1f,\"%s\",%s\r\n",
				    p.getId(),
				    p.getNombre(),
				    p.getTipo(),
				    p.getAltura_m(),
				    p.getPeso_kg(),
				    p.getHabilidadPrincipal(),
				    p.getEvoluciona_a()
				);

			}		
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}
		
}
