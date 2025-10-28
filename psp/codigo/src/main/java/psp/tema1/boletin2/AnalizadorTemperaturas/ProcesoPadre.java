package psp.tema1.boletin2.AnalizadorTemperaturas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ProcesoPadre {
	private static final String directorioFicheroCreado = "src/main/resources/";
	private static final String directorioFicheroTemperaturas = "src/main/resources/";
	private static final String directorioGenerarClases = "target/classes";
	private static final String rutaFicheroJava = "src/main/java/psp/tema1/boletin2/AnalizadorTemperaturas/ProcesoHijo.java" ;
	public static void main(String[] args) {
		int [] umbrales = {10,20,25,30,35};
		ProcesoPadre pp = new ProcesoPadre();
		for (int i : umbrales) {
			String i_String = Integer.toString(i);
			String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,directorioFicheroTemperaturas,i_String};
			ProcessBuilder pb1 = new ProcessBuilder(comando1);
			pp.ejecutaProceso(pb1);
		}

	}
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

	public void ejecutaProceso(ProcessBuilder pb) {
		try {
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

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
