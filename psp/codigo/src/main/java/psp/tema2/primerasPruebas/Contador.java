package psp.tema2.primerasPruebas;

public class Contador {
		   private int valor = 0;
		   public void incrementar() { 
		       valor++;
		   }
		   public int getValor() {
		       return valor;
		   }
		}

		class TareaIncremento implements Runnable {
		   private Contador contador;
		   public TareaIncremento(Contador contador) {
		       this.contador = contador;
		   }
		   @Override
		   public void run() {
		       for (int i = 0; i < 1000; i++) {
		           contador.incrementar();
		        	   try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		       }
		   }
		}

