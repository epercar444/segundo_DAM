package psp.tema2.boletin1;

import psp.tema2.primerasPruebas.MiHiloRunnable;

public class GestionaEjercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiHiloRunnable hilo1 = new MiHiloRunnable("Hilo1");
		Thread runnable = new Thread(hilo1);
		runnable.start();

		Ejercicio1Hilo2 hilo2 = new Ejercicio1Hilo2();
		hilo2.start();
	}

}
