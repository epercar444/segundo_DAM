package psp.tema2.monitores;

import java.util.ArrayList;
import java.util.List;

public class GestionaCuenta {
	
	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria(500.0f);
		List<Thread> hilos = new ArrayList<>();
		HiloIngresa hilo1 = new HiloIngresa(cuenta);
		HiloIngresa hilo2 = new HiloIngresa(cuenta);
		HiloRetira hilo3 = new HiloRetira(cuenta);
		HiloRetira hilo4 = new HiloRetira(cuenta);
		hilos.add(hilo1);
		hilos.add(hilo2);
		hilos.add(hilo3);
		hilos.add(hilo4);
		
		for (Thread t : hilos) {
			t.start();
			//System.out.println("El hilo "+t.getName()+" ha empezado");
		}
		for (Thread t : hilos) {
			try {
				t.join();
				//System.out.println("El hilo "+t.getName()+" ha terminado");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("En el padre:"+cuenta.getSaldo());
	}
}
