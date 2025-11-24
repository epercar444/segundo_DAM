package psp.tema2.boletin3;

public class MultiploCoopHilo7 extends Thread{
	private MultiplosCooperativos multiplos;
	
	public MultiploCoopHilo7(MultiplosCooperativos multiplos) {
		super();
		this.multiplos = multiplos;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		MultiplosCooperativos.multiplicar(7);
	}
}
