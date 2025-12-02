package psp.tema2.gasolinera;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaGasolineraTarjeta {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(3);
		List<Thread> hilos = new ArrayList<>();
		for (int i = 0; i < 7;i++) {
			GasolineraTarjeta hiloRunnable = new GasolineraTarjeta("Hilo"+i,semaforo);
			Thread hilo = new Thread(hiloRunnable);
			hilos.add(hilo);
		}
		
		for (Thread h:hilos) {
			h.start();
		}
		
		for (Thread h:hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
