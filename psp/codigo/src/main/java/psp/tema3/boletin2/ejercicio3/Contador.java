package psp.tema3.boletin2.ejercicio3;

public class Contador {
	private int total_conexiones;

	public Contador() {
		super();
		this.total_conexiones = 0;
	}

	public int getTotal_conexiones() {
		return total_conexiones;
	}

	public void setTotal_conexiones(int total_conexiones) {
		this.total_conexiones = total_conexiones;
	}
	
	public synchronized int contadorSuma () {
		return this.total_conexiones++;
	}
}
