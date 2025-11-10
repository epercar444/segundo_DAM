package psp.tema2.primerasPruebas;

public class MiHiloRunnable implements Runnable{
	
	private String nombreHilo;
	
	
	
	public MiHiloRunnable(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}



	@Override
	public void run() {
		Thread.currentThread().setName(nombreHilo);
		System.out.println("Ejecutando Hilo:"+Thread.currentThread().getName());
	}

}
