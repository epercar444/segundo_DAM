package psp.tema2.primerasPruebas;

import java.util.ArrayList;
import java.util.List;

public class GestionaHilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long inicio = System.currentTimeMillis();

		MiHilo hilo = new MiHilo("Hilo1");
		System.out.println(hilo.getState());
		MiHilo hilo1 = new MiHilo("Hilo2");
		
		//hilo.ejecutarHilos(hilos);
		long fin = System.currentTimeMillis();
		hilo.TiempoEjecucion(inicio, fin);
		
		/*hilo.start();
		System.out.println(hilo.getState());
		hilo1.start();
		
		System.out.println("En el main");*/

	}

}
