package psp.tema1.Simulacion2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcesoHijo {
	public static void main(String[] args) {
		String rutaFicheroABuscar = args[0] + "datos.txt";
		String ruta_numSegSocial = args[0] + "NSSs.txt";
		ProcesoHijo ph = new ProcesoHijo();
		
		try {
			ph.GeneraNSSFichero(rutaFicheroABuscar, ruta_numSegSocial);
			System.out.println(ph.GuardarNumSegSoc(rutaFicheroABuscar));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public List<String> GuardarNumSegSoc (String ruta) throws FileNotFoundException {
		List<String> numeros_segsocial = new ArrayList<>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			while (in.hasNext()) { 
				String linea = in.nextLine();
				String [] linea_split = linea.split(",");
				if (linea_split[0].startsWith("AN")) {
						numeros_segsocial.add(linea);
					}
				}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return numeros_segsocial;
	}
	
	public void GeneraNSSFichero (String rutaFicheroABuscar,String ruta) throws IOException {
		List<String> numeros_segsocial = GuardarNumSegSoc(rutaFicheroABuscar);
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for (String s : numeros_segsocial) {
				out.printf("%s %n" , s);
			}
			}		
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}


}
