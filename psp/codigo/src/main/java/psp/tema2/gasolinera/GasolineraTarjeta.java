package psp.tema2.gasolinera;
import java.util.concurrent.Semaphore;


public class GasolineraTarjeta implements Runnable{
	    private String nombreHilo;
	    private Semaphore semaforo;
	    

	    public GasolineraTarjeta(String nombreHilo, Semaphore semaforo) {
			super();
			this.nombreHilo = nombreHilo;
			this.semaforo = semaforo;
		}


		@Override
	    public void run() {
	        System.out.println(nombreHilo + " está pagando con tarjeta...");
	        try {
	            Thread.sleep(1000);
	            semaforo.acquire();
	            System.out.println(nombreHilo + " está repostando...");
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } finally {
	            semaforo.release();
	            System.out.println(nombreHilo + " ha terminado de repostar.");
	        }

}
}

