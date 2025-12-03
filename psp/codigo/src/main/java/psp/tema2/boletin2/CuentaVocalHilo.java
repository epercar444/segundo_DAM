package psp.tema2.boletin2;

public class CuentaVocalHilo implements Runnable {
	private String letra;
	private String texto;
	private VocalesTotales claseVocales;

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public VocalesTotales getClaseVocales() {
		return claseVocales;
	}


	public void setClaseVocales(VocalesTotales claseVocales) {
		this.claseVocales = claseVocales;
	}



	public CuentaVocalHilo(String letra, String texto,int contador) {
		super();
		this.letra = letra;
		this.texto = texto;
		this.claseVocales = new VocalesTotales(contador);
	}



	@Override
	public void run() {
		claseVocales.cuentaLetras(letra, texto);
		
	}

}
