package psp.tema1;

import java.io.IOException;

public class ejemplo {
	
	public static void main(String[] args) {
		Runtime kernel = Runtime.getRuntime();
		
		System.out.println(kernel.totalMemory());
		System.out.println(kernel.maxMemory());
		System.out.println(kernel.freeMemory());
		String [] arguments = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome"};
		try {
			kernel.exec(arguments);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
