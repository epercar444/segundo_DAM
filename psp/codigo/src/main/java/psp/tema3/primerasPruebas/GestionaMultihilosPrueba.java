package psp.tema3.primerasPruebas;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class GestionaMultihilosPrueba {
	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket("localhost",6000);
			List<Thread> hilos = new ArrayList<>();
			
			for (int i = 0; i<20;i++) {
				ManejadorHilosCliente hilo = new ManejadorHilosCliente(socket);
				hilos.add(hilo);
			}
			for (Thread t : hilos) {
				t.start();
			}
			for (Thread t : hilos) {
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
