package psp.tema2.boletin1;

public class Ejercicio1Hilo2 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("PROCESOS");
		}
	}
}
