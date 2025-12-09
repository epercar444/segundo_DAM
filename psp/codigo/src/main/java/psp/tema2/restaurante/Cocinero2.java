package psp.tema2.restaurante;

import java.util.concurrent.Semaphore;

public class Cocinero2 implements Runnable{
	private String nombreHilo;
	private Semaphore semaforoClientes,semaforoMenu;
	public Semaphore getSemaforoMenu() {
		return semaforoMenu;
	}


	public void setSemaforoMenu(Semaphore semaforoMenu) {
		this.semaforoMenu = semaforoMenu;
	}


	public String getNombreHilo() {
		return nombreHilo;
	}


	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}


	public Semaphore getSemaforo() {
		return semaforoClientes;
	}


	public void setSemaforo(Semaphore semaforoClientes) {
		this.semaforoClientes = semaforoClientes;
	}


	public Cocinero2(String nombreHilo, Semaphore semaforoClientes,Semaphore semaforoMenu) {
		super();
		this.nombreHilo = nombreHilo;
		this.semaforoClientes = semaforoClientes;
		this.semaforoMenu = semaforoMenu;
	}


	@Override
	public void run() {
		while (true) {
		try {
			semaforoClientes.acquire(3);
			System.out.println(nombreHilo+" cocinando");
			Thread.sleep(4000);
			System.out.println(nombreHilo + " ha dejado de cocinar");
			semaforoMenu.release(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 
		
	}

}
