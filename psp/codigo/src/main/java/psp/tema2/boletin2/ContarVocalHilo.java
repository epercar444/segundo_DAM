package psp.tema2.boletin2;

public class ContarVocalHilo extends Thread{
	
	
	private CuentaVocales obj;
	private String texto;
	private char vocal;
	private int numVocales = 0;
	
	
	public ContarVocalHilo(CuentaVocales obj, String texto, char vocal) {
		super();
		this.obj = obj;
		this.texto = texto;
		this.vocal = vocal;
	}
	
	
	
	public int contar() {
		int contador=0;
		for (char a: this.texto.toCharArray()) {
			if(a == this.vocal) {
				contador++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return contador;
	}
	

	
	@Override
	public void run() {
		numVocales = this.contar();
		this.obj.incrementaVocalesTotales(numVocales);
	}
}
