package psp.tema2.boletin3;

public class Multiplos implements Runnable{
	private int numero;
	

	public Multiplos(int numero) {
		super();
		this.numero = numero;
	}

	@Override
	public void run() {
		for (int i =1; i < 10;i++) {
			System.out.println(numero*i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
