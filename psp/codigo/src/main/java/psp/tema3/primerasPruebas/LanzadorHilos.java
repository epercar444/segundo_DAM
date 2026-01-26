package psp.tema3.primerasPruebas;

public class LanzadorHilos {
	//sirve para probar que puedes lanzar muchos hilos de forma simultánea
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i<5; i++) {
			ClienteHilo hilo = new ClienteHilo();
			hilo.start();
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
