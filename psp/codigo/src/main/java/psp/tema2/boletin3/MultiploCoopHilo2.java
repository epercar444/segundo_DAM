package psp.tema2.boletin3;

public class MultiploCoopHilo2 extends Thread{
	private MultiplosCooperativos multiplos;
	
	
	public MultiploCoopHilo2(MultiplosCooperativos multiplos) {
		super();
		this.multiplos = multiplos;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		MultiplosCooperativos.multiplicar(2);
	}
}
