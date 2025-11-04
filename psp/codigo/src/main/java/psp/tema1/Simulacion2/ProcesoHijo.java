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
	//la idea principal era lnazar dos procesos hijos a la vez (es decir, dos clases distintas), una para DNIs y otra para NSSs
	public static void main(String[] args) {
		String rutaFicheroABuscar = args[0] + "datos.txt";
		String ruta_DNIs = args[0] + "DNIs.txt";
		String ruta_numSegSocial = args[0] + "NSSs.txt";
		String ruta_resumen = args[0] + "resumen.txt";
		ProcesoHijo ph = new ProcesoHijo();
		
		try {
			ph.GeneraNSSFichero(rutaFicheroABuscar, ruta_numSegSocial);
			ph.GeneraDNIsFichero(rutaFicheroABuscar, ruta_DNIs);
			ph.GeneraFicheroResumen(rutaFicheroABuscar, ruta_resumen);
			System.out.println(ph.GuardarDNIs(rutaFicheroABuscar));
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
	
	public List<String> GuardarDNIs (String ruta) throws FileNotFoundException {
		List<String> dnis = new ArrayList<>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			while (in.hasNext()) { 
				String linea = in.nextLine();
				List<String> numSegSocial = GuardarNumSegSoc(ruta);
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
	
	public void GeneraFicheroResumen (String rutaFicheroABuscar,String ruta) throws IOException {
		List<String> numeros_segsocial = GuardarNumSegSoc(rutaFicheroABuscar);
		List<String> DNIs = GuardarDNIs(rutaFicheroABuscar);
		int num_Dnis = DNIs.size();
		int num_NumSegSocial = numeros_segsocial.size();
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
				out.printf("Número total de contribuyentes tratados: %n DNIs tratados: %d %n NSSs tratados: %d %n" , num_Dnis,num_NumSegSocial);
			}		
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}


}
