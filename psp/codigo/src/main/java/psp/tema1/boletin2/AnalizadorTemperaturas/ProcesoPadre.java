package psp.tema1.boletin2.AnalizadorTemperaturas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ProcesoPadre {
	private static final String directorioFicheroCreado = "src/main/resources/";
	private static final String directorioFicheroTemperaturas = "src/main/resources/temperaturas.txt";
	private static final String directorioGenerarClases = "target/classes";
	private static final String rutaFicheroJava = "src/main/java/psp/tema1/boletin2/AnalizadorTemperaturas/ProcesoHijo.java" ;
	public static void main(String[] args) {
		ProcesoPadre pp = new ProcesoPadre();
		String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,directorioFicheroTemperaturas,"10",(directorioFicheroCreado+"10.txt")};
		String[] comando2 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,directorioFicheroTemperaturas,"20",(directorioFicheroCreado+"20.txt")};
		String[] comando3 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,directorioFicheroTemperaturas,"25",(directorioFicheroCreado+"25.txt")};
		String[] comando4 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,directorioFicheroTemperaturas,"30",(directorioFicheroCreado+"30.txt")};
		String[] comando5 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,directorioFicheroTemperaturas,"35",(directorioFicheroCreado+"35.txt")};

		ProcessBuilder pb1 = new ProcessBuilder(comando1);
		ProcessBuilder pb2 = new ProcessBuilder(comando2);
		ProcessBuilder pb3 = new ProcessBuilder(comando3);
		ProcessBuilder pb4 = new ProcessBuilder(comando4);
		ProcessBuilder pb5 = new ProcessBuilder(comando5);
		pp.ejecutaProceso(pb1);
		pp.ejecutaProceso(pb2);
		pp.ejecutaProceso(pb3);
		pp.ejecutaProceso(pb4);
		pp.ejecutaProceso(pb5);

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
