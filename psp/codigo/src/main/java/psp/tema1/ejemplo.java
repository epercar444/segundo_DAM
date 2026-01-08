package psp.tema1;

import java.io.IOException;

public class ejemplo {
	
	public static void main(String[] args) {
		Runtime kernel = Runtime.getRuntime();
		
		/*System.out.println(kernel.totalMemory());
		System.out.println(kernel.maxMemory());
		System.out.println(kernel.freeMemory());*/
		String [] arguments = {"NotePad.exe"};
		Process proceso;
		try {
			proceso = kernel.exec(arguments);
			int codigoRetorno = proceso.waitFor(); //Espero a que termine
			System.out.println("Llego al final " + codigoRetorno); }
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

