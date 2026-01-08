package psp.SimulacionUd1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProcesoPadre {
	private static final String directorioFicheroPedidos = "src/main/resources/";
	private static final String directorioGenerarClases = "target/classes";
	private static final String rutaFicheroJava = "src/main/java/psp/SimulacionUd1/ProcesoHijo.java" ;
	public static void main(String[] args) {
		String [] provincias = {"Sevilla","Huelva","Jaén","Granada","Córdoba","Cádiz","Málaga","Almería"};
		ProcesoPadre pp = new ProcesoPadre();
		for (String i : provincias) {
			String[] comando1 = {"java", "-cp", directorioGenerarClases,"psp.SimulacionUd1.ProcesoHijo",directorioFicheroPedidos,i};
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
			//pb.inheritIO(); //no en el flujo de salida, sino pantalla
			Process p1 = pb.start();


			BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

			int exit = p1.waitFor();
			//System.out.println(exit);

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
