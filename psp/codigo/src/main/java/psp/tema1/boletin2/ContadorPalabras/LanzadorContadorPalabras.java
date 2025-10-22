package psp.tema1.boletin2.ContadorPalabras;

import java.io.IOException;

public class LanzadorContadorPalabras {
	private static final String rutaFicheroJava = "src/main/java/psp/tema1/boletin2/ContadorPalabras/ContadorPalabras.java" ;
	private static final String directorioGenerarClases = "target/classes";
	public static void main(String[] args) {
		LanzadorContadorPalabras lanzarPalabras = new LanzadorContadorPalabras();
		String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,"fichero.txt" ,"es"};
		String[] comando2 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,"fichero.txt" ,"Java"};
		String[] comando3 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,"fichero.txt" ,"y"};
		ProcessBuilder pb = new ProcessBuilder(comando1);
		ProcessBuilder pb2 = new ProcessBuilder(comando2);
		ProcessBuilder pb3 = new ProcessBuilder(comando3);
		lanzarPalabras.ejecutaProceso(pb);
		lanzarPalabras.ejecutaProceso(pb2);
		lanzarPalabras.ejecutaProceso(pb3);
	}
	public void compilaProceso() {
		String[] comando = { "javac", "-d", rutaFicheroJava, "ContadorPalabras.java"};
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			int exist = p1.waitFor();
			System.out.println(exist);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ejecutaProceso(ProcessBuilder pb) {
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			int exist = p1.waitFor();
			System.out.println(exist);
		} catch (IOException e) {
			e.printStackTrace();
	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



}
}

