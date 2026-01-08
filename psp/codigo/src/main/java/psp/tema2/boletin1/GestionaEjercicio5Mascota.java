package psp.tema2.boletin1;

import java.util.ArrayList;
import java.util.List;

public class GestionaEjercicio5Mascota {
	public static void main(String[] args) {
		Ejercicico5Mascota mascota = new Ejercicico5Mascota("Lulú");
		
		List<Thread> cuidadores = new ArrayList<Thread>();
				
		for (int i = 1; i <= 10; i++) {
			Thread cuidador = new Thread(mascota,"cuidador"+i);
			cuidadores.add(cuidador);
			/*if (i%2==0) {
				cuidador.setPriority(Thread.MAX_PRIORITY);
			}
			else {
				cuidador.setPriority(Thread.MIN_PRIORITY);
			}*/
			cuidador.setPriority(11-i);
			cuidador.start();
			System.out.println(cuidador.getPriority());
		}
		
		for (Thread c : cuidadores) {
			try {
				c.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(mascota.getNumVecesCome());
	}
}
