package psp.tema1.boletin2.Ejercicio11;

import java.io.IOException;

public class LanzadorJAR {
	public void EjecutaJAR (){
		 String[] comando = {"java", "-jar","target/boletin2.jar"};
		 ProcessBuilder pb = new ProcessBuilder(comando);
			try {
				pb.redirectErrorStream(true);
				pb.inheritIO();
				Process p = pb.start();
				int exist = p.waitFor();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
