package file.lecturaYEscrituraFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ContadorPalabras {
	public int ContadorPalabras (String palabra, File ruta) throws FileNotFoundException {
		int contador = 0;
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			while (in.hasNext()) { 
				String linea = in.nextLine();
				String[] linea_split = linea.split(" ");
				for (String e : linea_split) {
					String palabra_Es = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
					if (e.equalsIgnoreCase(palabra)) {
						contador += 1;
					}
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return contador;
	}
	
	public void CreaFicheroEs (int numero,File ruta) throws IOException {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			out.printf("El número de veces que aparece dicha palabra es: %d %n" , numero);
			}		
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}
		
}