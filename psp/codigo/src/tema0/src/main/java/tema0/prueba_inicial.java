package tema0;

import java.util.List;

public class prueba_inicial {
	
	int metodo1 (int[] numeros) {
		int suma = 0;
		for (int numero : numeros) {
			suma = suma + numero;
		}
		return suma;
	}
	
	int metodo1 (List<Integer> numeros) {
		int suma = 0;
		for (int numero : numeros) {
			suma = suma + numero;
		}
		return suma;
	}
}
