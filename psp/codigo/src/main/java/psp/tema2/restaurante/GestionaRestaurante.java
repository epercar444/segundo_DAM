package psp.tema2.restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRestaurante {
	public static void main(String[] args) {
		List<Thread> hilos = new ArrayList<>();
		Semaphore semaforo = new Semaphore(3);
		try {
			semaforo.acquire(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cocinero cocinero = new Cocinero("Cocinero", semaforo);
		Thread cocineroHilo = new Thread(cocinero);
		
		hilos.add(cocineroHilo);
		for (int i = 0; i <= 3; i++) {
			Comensal comensal = new Comensal("Comensal"+i, semaforo);
			Thread comensalHilo = new Thread(comensal);
			hilos.add(comensalHilo);
		}
		
		for (Thread h : hilos) {
			h.start();
		}
		
		for (Thread h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		
	}
	
	
}
