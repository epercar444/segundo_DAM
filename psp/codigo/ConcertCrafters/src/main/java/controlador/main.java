package controlador;

import excepciones.CraftersException;
import modelo.Deportivo;

public class main {

	public static void main(String[] args) {
		//1.
		try {
			Deportivo d1 = new Deportivo(600, 500, null, null, null, false);
		} catch (CraftersException e) {
			System.out.println(e.getMessage());	  }
		

	}

}
