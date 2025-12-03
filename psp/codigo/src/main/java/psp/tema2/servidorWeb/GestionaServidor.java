package psp.tema2.servidorWeb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaServidor {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(12);
		List<Thread> hilos = new ArrayList<>();
		for (int i = 0; i < 21;i++) {
			servidorWeb hiloRunnable = new servidorWeb("Hilo"+i,semaforo);
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
