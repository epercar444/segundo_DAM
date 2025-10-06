package psp.tema1;

import java.io.IOException;

public class Lanzador {
	private static final String directorioGeneralCasa = "C:\\Users\\evape\\Onedrive\\Escritorio\\segundo_DAM\\psp\\codigo\\target\\classes";
	private static final String directorioGenerarClasses = "C:\\Users\\alumno\\Desktop\\segundo_DAM\\psp\\codigo\\target\\classes\\Gestiona.java";
	private static final String rutaSource = "C:\\Users\\alumno\\Desktop\\segundo_DAM\\psp\\codigo\\src\\main\\java\\psp\\tema1\\Gestiona.java";
	public static void main(String[] args) {
		Lanzador lanzador = new Lanzador();
		//lanzador.ejecutaProcesoCompila();
		lanzador.ejecutaProcesoJava();
	} 

public void ejecutaProcesoCompila() {
	String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSource };
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
public void ejecutaProcesoJava() {
	 String[] comando = {"java", "-cp", this.directorioGeneralCasa, "psp.tema1.Gestiona"};
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
