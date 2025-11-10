package psp.tema2.primerasPruebas;

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
	
}
