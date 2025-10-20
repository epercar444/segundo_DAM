package psp.tema1.boletin1;

import java.io.IOException;

public class LanzadorPyhton {
	private static final String directorioGeneral = "C:\\Users\\alumno\\Desktop\\segundo_DAM\\psp\\codigo\\src\\main\\resources\\ejemplo.py";
	public void ejecutaProcesoPyhton() {
		 String[] comando = {"python", directorioGeneral};
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
