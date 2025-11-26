package psp.tema2.boletin3;

public class MultiplosCooperativos {
	//prueba synchronized, static y sin nada
	public static synchronized void multiplicar (int numero) {
		for (int i =1; i < 10;i++) {
			System.out.println(numero*i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
