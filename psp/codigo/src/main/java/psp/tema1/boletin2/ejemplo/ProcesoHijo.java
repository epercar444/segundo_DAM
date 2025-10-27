package psp.tema1.boletin2.ejemplo;

import java.io.FileNotFoundException;

public class ProcesoHijo {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(8);
		throw new FileNotFoundException("Error padre");
	}

}
