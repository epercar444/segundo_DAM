package psp.tema2.monitores;

public class HiloIngresa extends Thread{
	private CuentaBancaria cuenta;
	private int importe;

	public HiloIngresa(CuentaBancaria cuenta1) {
		super();
		this.importe = ((int)(Math.random()*500+1));
		this.cuenta = cuenta1;
	}
	
	@Override
	public void run() {
	    try {
	        cuenta.ingresa(importe);
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        System.out.println(e.getMessage());
	    }
	}

}
