package psp.tema3.boletin2.ejercicio3;

public class LanzadorHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			ClienteHiloEjercicio3 hilo = new ClienteHiloEjercicio3();
			hilo.start();
		}
	}

}
