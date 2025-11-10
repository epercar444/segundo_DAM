package psp.tema2.primerasPruebas;

public class GestionaHiloRunnable {
	public static void main(String[] args) {
		MiHiloRunnable hilorunnable1 = new MiHiloRunnable("Hilo1");
		MiHiloRunnable hilorunnable2 = new MiHiloRunnable("Hilo2");
		
		System.out.println("Hilo principal terminado");
	}

}
