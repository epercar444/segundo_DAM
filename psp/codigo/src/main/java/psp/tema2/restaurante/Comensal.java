package psp.tema2.restaurante;

import java.util.concurrent.Semaphore;

public class Comensal implements Runnable{
	private String nombreHilo;
	private Semaphore semaforo;
	

	public String getNombreHilo() {
		return nombreHilo;
	}


	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}


	public Semaphore getSemaforo() {
		return semaforo;
	}


	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}


	public Comensal(String nombreHilo, Semaphore semaforo) {
		super();
		this.nombreHilo = nombreHilo;
		this.semaforo = semaforo;
	}


	@Override
	public void run() {
		while (true) {
		try {
			semaforo.acquire();
			System.out.println(nombreHilo+" comiendo");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}

}
