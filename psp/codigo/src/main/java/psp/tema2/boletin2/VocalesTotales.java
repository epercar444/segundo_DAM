package psp.tema2.boletin2;

public class VocalesTotales {
	private int contador;

	public VocalesTotales(int contador) {
		super();
		this.contador = contador;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	public synchronized void cuentaLetras(String letra, String texto) {
		int contador = 0;

		char buscada = letra.toLowerCase().charAt(0);

		for (int i = 0; i < texto.length(); i++) {
			if (Character.toLowerCase(texto.charAt(i)) == buscada) {
				contador++;
			}
		}
		this.contador = this.contador+contador;
	}
}
