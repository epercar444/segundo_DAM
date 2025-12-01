package psp.tema2.gasolinera;

import java.util.concurrent.Semaphore;

public class Coche implements Runnable{
	private String nombreHilo;
	private Semaphore semaforo;
	
	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public Coche(String nombreHilo,Semaphore semaforo) {
		super();
		this.nombreHilo = nombreHilo;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			System.out.println(nombreHilo + " repostando");	
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			semaforo.release();
			System.out.println(nombreHilo +" ha dejado de respostar");
		}
	}

}
