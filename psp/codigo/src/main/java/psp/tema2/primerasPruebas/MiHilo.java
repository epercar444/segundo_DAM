package psp.tema2.primerasPruebas;

import java.util.List;

public class MiHilo extends Thread{
	
	private String nombreHilo;
	
	
	
	
	public MiHilo(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}




	@Override
	public void run() {
		System.out.println(this.nombreHilo + " estado:" + this.getState());
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termina hilo: "+this.nombreHilo);
		// TODO Auto-generated method stub
		super.run();
	}
	
	public void TiempoEjecucion (long inicio,long fin){
	        long duracion = fin - inicio;
	        System.out.println("Tiempo de ejecución: " + duracion + " ms");
	    }
	
	public void ejecutarHilos(List<MiHilo> hilos) {
	    for (Thread hilo : hilos) {
	        hilo.start();
	    }
	    for (Thread hilo : hilos) {
	        try {
	            hilo.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    System.out.println("Todos los hilos han terminado.");
	}

	}

	

