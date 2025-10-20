package psp.tema1;

import java.io.IOException;

public class Lanzador {
	private static final String directorioGeneralCasa = "target\\classes\\tema1\\Gestiona";
	private static final String directorioGenerarClasses = "target\\classes\\";
	private static final String rutaSource = "src\\main\\java\\psp\\tema1\\Gestiona.java";
	public static void main(String[] args) {
		Lanzador lanzador = new Lanzador();
		lanzador.ejecutaProcesoCompila();
		lanzador.ejecutaProcesoJava();
	} 

public void ejecutaProcesoCompila() {
	String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSource };
	ProcessBuilder pb = new ProcessBuilder(comando);
	try {
		pb.redirectErrorStream(true);
		pb.inheritIO();
		Process hijo = pb.start();
		int exist = hijo.waitFor();
		System.out.println(exist);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void ejecutaProcesoJava() {
	 String[] comando = {"java", "-cp", "target/classes", "psp.tema1.Gestiona","hola","caracola"};
	 ProcessBuilder pb = new ProcessBuilder(comando);
	try {
		pb.redirectErrorStream(true);
		pb.inheritIO();
		Process p = pb.start();
		int exist = p.waitFor();
		System.out.println(exist);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
