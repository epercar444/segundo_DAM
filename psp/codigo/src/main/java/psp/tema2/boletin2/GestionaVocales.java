package psp.tema2.boletin2;

public class GestionaVocales {
	
	public static void main(String[]args) throws InterruptedException {
		String txt = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa  sooo uuuuddddds  e i";
		CuentaVocales cc = new CuentaVocales();
		
		ContarVocalHilo h1 = new ContarVocalHilo(cc, txt, 'a' );
		ContarVocalHilo h2 = new ContarVocalHilo(cc, txt, 'i' );
		ContarVocalHilo h3 = new ContarVocalHilo(cc, txt, 'e' );
		ContarVocalHilo h4 = new ContarVocalHilo(cc, txt, 'o' );
		ContarVocalHilo h5 = new ContarVocalHilo(cc, txt, 'u' );
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		h1.join();
		h2.join();
		h3.join();
		h4.join();
		h5.join();
		System.out.println("hay "+cc.getVocalesTotales()+ " Vocales");
	}
}