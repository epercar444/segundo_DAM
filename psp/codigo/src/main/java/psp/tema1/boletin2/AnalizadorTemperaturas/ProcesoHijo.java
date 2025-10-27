package psp.tema1.boletin2.AnalizadorTemperaturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProcesoHijo {
	public static void main(String[] args) {
		ProcesoHijo pb = new ProcesoHijo();
		String ruta_ficheroTemperaturas = args [0];
		int numeroTemperatura = Integer.parseInt(args[1]);
		String ruta_localFicherosCreados = args[2];
		try {
			System.out.println(pb.ContadorTemperaturasSuperiorA(ruta_ficheroTemperaturas, numeroTemperatura));
			pb.CreaFicheroTemperatura(ruta_ficheroTemperaturas, numeroTemperatura, ruta_localFicherosCreados);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int ContadorTemperaturasSuperiorA (String ruta,int temperatura) throws FileNotFoundException {
		int contador = 0;
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			while (in.hasNext()) { 
				String linea = in.nextLine();
				if (Integer.parseInt(linea) >= temperatura) {
						contador += 1;
					}
				}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return contador;
	}
	public void CreaFicheroTemperatura (String rutaFicheroABuscar,int temperatura,String ruta) throws IOException {
		int contador = ContadorTemperaturasSuperiorA(rutaFicheroABuscar,temperatura);
		String contadorString = Integer.toString(contador);
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			out.printf("El número de veces que se supera dicha temperatura es: %d %n" , contador);
			}		
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}
	
}
