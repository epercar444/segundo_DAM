package examen;

public class LanzadorHilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				for (int i = 0; i < 9; i++) {
					ClienteHilo hilo = new ClienteHilo();
					hilo.start();
				Thread.sleep(2000);
			}
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


