package psp.tema2.restaurante;

import java.util.concurrent.Semaphore;

public class Comensal2 implements Runnable{
	private String nombreHilo;
	private Semaphore semaforoClientes,semaforoMenu;
	

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public Semaphore getSemaforo() {
		return semaforoClientes;
	}

	public Semaphore getSemaforoMenu() {
		return semaforoMenu;
	}


	public void setSemaforoMenu(Semaphore semaforoMenu) {
		this.semaforoMenu = semaforoMenu;
	}


	public void setSemaforo(Semaphore semaforoClientes) {
		this.semaforoClientes = semaforoClientes;
	}


	public Comensal2(String nombreHilo, Semaphore semaforoClientes,Semaphore semaforoMenu) {
		super();
		this.nombreHilo = nombreHilo;
		this.semaforoClientes = semaforoClientes;
		this.semaforoMenu = semaforoMenu;
	}


	@Override
	public void run() {
		while (true) {
		try {
			System.out.println(nombreHilo+" tiene hambre");
			semaforoClientes.release();
			semaforoMenu.acquire();
			System.out.println(nombreHilo + " comiendo");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println(nombreHilo+" ha dejado de comer");
		}
		}
		
		
	}

}
