package psp.tema1.boletin2;

import java.io.IOException;

public class LanzadorSuma {
	public void ejecutaProcesoCompila() {
		String[] comando = { "javac", "-d", "src/main/java/psp/tema1", "ProcesoHijo_CalculaSuma"};
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
		 String[] comando = {"java", "-cp", "target/classes", "psp.tema1.boletin2.ProcesoHijo_CalculaSuma","par","10"};
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
