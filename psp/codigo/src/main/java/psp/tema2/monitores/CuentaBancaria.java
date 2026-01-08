package psp.tema2.monitores;

public class CuentaBancaria {
	private float saldo;
	public float getSaldo() {
		return saldo;
	}


	public CuentaBancaria(float saldo) {
		super();
		this.saldo = saldo;
	}
	
	public synchronized void ingresa (float importe) {
		this.saldo = saldo + importe;
        System.out.println("Ingreso de " + importe + " realizado. Saldo actual: " + this.saldo);
	}
	public synchronized void retira (float importe) throws NotSaldoException {
		if (saldo < importe) {
			throw new NotSaldoException("No se ha podido retirar dicho importe porque el saldo es insuficiente");
		}
		this.saldo = saldo - importe;
        System.out.println("Retiro de " + importe + " realizado. Saldo actual: " + this.saldo);
	}
}
