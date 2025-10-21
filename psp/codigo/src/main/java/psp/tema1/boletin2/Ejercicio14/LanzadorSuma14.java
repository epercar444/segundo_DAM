package psp.tema1.boletin2.Ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzadorSuma14 {
	public void ejecutaProcesoCompila() {
		String[] comando = { "javac", "-d", "src/main/java/psp/tema1", "ProcesoHijo_CalculaSuma"};
		try {
			Process pb = Runtime.getRuntime().exec(comando);
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(pb.getInputStream()));
			String linea;
		        while ((linea = errorReader.readLine()) != null) {
		            System.out.println(linea);
		        }		
				int exist = pb.waitFor();
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
		try {
			Process pb = Runtime.getRuntime().exec(comando);
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(pb.getInputStream()));
			String linea;
		        while ((linea = errorReader.readLine()) != null) {
		            System.out.println(linea);
		        }		
				int exist = pb.waitFor();
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
