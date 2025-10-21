package file.segundo_boletin.Paises.utiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import file.segundo_boletin.Paises.Pais;

public class GestionaFicherosPaises {
	public List<Pais> ListaPaises (String ruta) throws FileNotFoundException {
		List<Pais> paises = new ArrayList<>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			in.nextLine();
			while (in.hasNext()) { 
				String linea = in.nextLine();
				String[] linea_split = linea.split(",");
				if (linea!=null && !paises.contains(linea)) {
					String nombre = linea_split[0];
					String continente = linea_split[1];
					int poblacion = Integer.parseInt(linea_split[2]);
					String idioma = linea_split[3];
					String moneda = linea_split[4];
					Pais pais = new Pais(nombre, continente, idioma, moneda, poblacion);
					paises.add(pais);
				}
				}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return paises;
	}
}
