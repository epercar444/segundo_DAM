package psp.tema3.boletin2.ejercicio01;


public class LanzadorHilosEjercicio01 {
	public static void main(String[] args) {
		for (int i = 0; i<10; i++) {
			ClienteHiloEjercicio01 hilo = new ClienteHiloEjercicio01();
			hilo.start();
		}
	}
}
