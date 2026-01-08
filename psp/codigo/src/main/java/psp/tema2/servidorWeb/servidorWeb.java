package psp.tema2.servidorWeb;

import java.util.concurrent.Semaphore;

public class servidorWeb implements Runnable{
	private String nombreHilo;
	private Semaphore semaforo;
	
	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public servidorWeb(String nombreHilo,Semaphore semaforo) {
		super();
		this.nombreHilo = nombreHilo;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			System.out.println(nombreHilo + " haciendo petición");	
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			semaforo.release();
			System.out.println(nombreHilo +" ha dejado de hacer la petición");
		}
	}

}

