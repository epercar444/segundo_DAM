package psp.tema3.boletin2.ejercicio4;

public class Contador {
	private int idCliente;

	public Contador() {
		super();
		this.idCliente = 0;
	}

	public int getTotal_conexiones() {
		return idCliente;
	}

	public void setTotal_conexiones(int total_conexiones) {
		this.idCliente = total_conexiones;
	}
	
	public synchronized int contadorId () {
		return this.idCliente++;
	}
}
