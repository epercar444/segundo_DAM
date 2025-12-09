package psp.tema2.restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRestaurante2 {
	public static void main(String[] args) {
	List<Thread> hilos = new ArrayList<>();
	Semaphore semaforoMenu = new Semaphore(1);
	Semaphore semaforoClientes = new Semaphore(3);
	try {
		semaforoMenu.acquire(1);
		semaforoClientes.acquire(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Cocinero2 cocinero = new Cocinero2("Cocinero", semaforoClientes,semaforoMenu);
	Thread cocineroHilo = new Thread(cocinero);
	
	hilos.add(cocineroHilo);
	for (int i = 1; i <= 3; i++) {
		Comensal2 comensal = new Comensal2("Comensal"+i, semaforoClientes,semaforoMenu);
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