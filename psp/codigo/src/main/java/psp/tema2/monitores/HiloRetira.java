package psp.tema2.monitores;

public class HiloRetira extends Thread{
	private CuentaBancaria cuenta;
	private int importe;

	public HiloRetira(CuentaBancaria cuenta1) {
		super();
		this.importe = ((int)(Math.random()*500+1));
		this.cuenta = cuenta1;
	}
	
	@Override
	public void run() {
	    try {
	        cuenta.retira(importe);
	        Thread.sleep(2000);
	    } catch (NotSaldoException | InterruptedException e) {
	        System.out.println(e.getMessage());
	    }
	}

}
