package psp.tema2.boletin2;

public class CuentaVocales {
	
	private int vocalesTotales = 0;

	public CuentaVocales() {
		super();
	}

	public int getVocalesTotales() {
		return vocalesTotales;
	}

	synchronized void incrementaVocalesTotales(int vocalesTotales) {
		this.vocalesTotales = this.vocalesTotales+ vocalesTotales;
	}
	
	
	
}
