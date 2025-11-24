package psp.tema2.boletin3;

public class GestionaMultiplos {

	public static void main(String[] args) {
		long t_comienzo = System.currentTimeMillis();
		Multiplos multDe2 = new Multiplos(2);
		Multiplos multDe3 = new Multiplos(3);
		Multiplos multDe7 = new Multiplos(7);


		Thread hilo1 = new Thread(multDe2);
		Thread hilo2 = new Thread(multDe3);
		Thread hilo3 = new Thread(multDe7);
		try {
			hilo1.start();
			hilo2.start();
			hilo3.start();
			hilo1.join();
			hilo2.join();
			hilo3.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		long t_fin = System.currentTimeMillis();
		long tiempototal = t_fin - t_comienzo;
		System.out.println("El proceso total ha tardado= " + tiempototal + "mseg");
	}

}
