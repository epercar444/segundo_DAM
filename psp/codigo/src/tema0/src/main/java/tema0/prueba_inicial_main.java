package tema0;

import java.util.ArrayList;
import java.util.List;

public class prueba_inicial_main {

	public static void main(String[] args) {
		List<Integer> numeros1 = new ArrayList<>();
		numeros1.add(1);
		numeros1.add(2);
		numeros1.add(3);
		int [] numeros = {1,2,3};
		prueba_inicial p = new prueba_inicial();
		
		System.out.println(p.metodo1(numeros));
		System.out.println(p.metodo1(numeros1));
		
		//sobre-escritura
	}

}
