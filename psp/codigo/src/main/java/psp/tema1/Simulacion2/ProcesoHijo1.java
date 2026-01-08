package psp.tema1.Simulacion2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcesoHijo1 {

	public static void main(String[] args) {
		String rutaFicheroABuscar = args[0] + "datos.txt";
		String ruta_DNIs = args[0] + "DNIs.txt";
		ProcesoHijo1 ph1 = new ProcesoHijo1();
		try {
			ph1.GeneraDNIsFichero(rutaFicheroABuscar, ruta_DNIs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public List<String> GuardarDNIs (String ruta) throws FileNotFoundException {
		ProcesoHijo ph = new ProcesoHijo();
		List<String> dnis = new ArrayList<>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			while (in.hasNext()) { 
				String linea = in.nextLine();
				List<String> numSegSocial = ph.GuardarNumSegSoc(ruta);
				if (!numSegSocial.contains(linea)) {
						dnis.add(linea);
					}
				}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return dnis;
	}
	
	public void GeneraDNIsFichero (String rutaFicheroABuscar,String ruta) throws IOException {
		List<String> dnis = GuardarDNIs(rutaFicheroABuscar);
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for (String s : dnis) {
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
