package psp.tema2.primerasPruebas;

public class GestionaHilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiHilo hilo = new MiHilo("Hilo1");
		System.out.println(hilo.getState());
		MiHilo hilo1 = new MiHilo("Hilo2");
		
		hilo.start();
		System.out.println(hilo.getState());
		hilo1.start();
		
		System.out.println("En el main");

	}

}
