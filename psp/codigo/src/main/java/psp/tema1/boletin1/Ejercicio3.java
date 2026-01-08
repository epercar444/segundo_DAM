package psp.tema1.boletin1;

import java.io.IOException;

public class Ejercicio3 {
	public static void main(String[] args) {
		String[] comando = {"cmd.exe", "/C", "start", "cmd.exe", "/K", "tasklist"};
			    ProcessBuilder pb = new ProcessBuilder(comando);
			    try {
					Process p = pb.start();
					
					System.out.println("Acabo cmd");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	}

}


