package psp.tema3.boletin2.ejercicio2;

public class LanzadorHilosEjercicio2 {

	public static void main(String[] args) {
		for (int i = 0; i<5; i++) {
			ClienteHiloEjercicio2 hilo = new ClienteHiloEjercicio2();
			hilo.start();
		}

	}

}
