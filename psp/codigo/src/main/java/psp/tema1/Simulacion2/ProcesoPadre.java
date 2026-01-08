package psp.tema1.Simulacion2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProcesoPadre {
	private static final String directorioFicheroResources = "src/main/resources/";
	private static final String directorioGenerarClases = "target/classes";
	private static final String rutaFicheroJava = "src/main/java/psp/tema1/Simulacion2/ProcesoHijo.java" ;
	private static final String rutaFicheroJava1 = "src/main/java/psp/tema1/Simulacion2/ProcesoHijo1.java" ;
	private static final String rutaFicheroABuscar = "src/main/resources/datos.txt";
	private static final String ruta = "src/main/resources/resumen.txt";
	public void compilaProceso() {
		String[] comando = { "javac", "-d", directorioGenerarClases,rutaFicheroJava};
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			int exist = p1.waitFor();
			//System.out.println(exist);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ejecutaProceso() {
		List<ProcessBuilder> procesos = new ArrayList<>();
		 String[] comando = {"java", "-cp", directorioGenerarClases, rutaFicheroJava,directorioFicheroResources};
		 ProcessBuilder procesohijo = new ProcessBuilder(comando);
		 String[] comando1 = {"java", "-cp", directorioGenerarClases, rutaFicheroJava1,directorioFicheroResources};
		 ProcessBuilder procesohijo1 = new ProcessBuilder(comando1);
		 procesos.add(procesohijo);
		 procesos.add(procesohijo1);
		try {
			for (ProcessBuilder pb : procesos) {
				// pb.redirectErrorStream(true);
				// pb.inheritIO(); no en el flujo de salida, sino pantalla
				Process p1 = pb.start();
				BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
				BufferedReader errorReader = new BufferedReader(new InputStreamReader(p1.getErrorStream()));
				int exit = p1.waitFor();
				System.out.println(exit);

				if (exit != 0) {
					String errorLinea = errorReader.readLine();
					while (errorLinea != null) {
						System.err.println("Error Padre: " + errorLinea);
						errorLinea = errorReader.readLine();
					}
				} else {
					String linea = reader.readLine();

					while (linea != null) {
						System.out.println("Padre: " + linea);
						linea = reader.readLine();
					}

				} } } catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		finally {
			try {
				GeneraFicheroResumen(rutaFicheroABuscar,ruta);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	public void GeneraFicheroResumen (String rutaFicheroABuscar,String ruta) throws IOException {
		ProcesoHijo ph = new ProcesoHijo();
		ProcesoHijo1 ph1 = new ProcesoHijo1();
		List<String> numeros_segsocial = ph.GuardarNumSegSoc(rutaFicheroABuscar);
		List<String> DNIs = ph1.GuardarDNIs(rutaFicheroABuscar);
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

