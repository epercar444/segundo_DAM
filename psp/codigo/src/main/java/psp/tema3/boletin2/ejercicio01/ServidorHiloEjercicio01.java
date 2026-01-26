package psp.tema3.boletin2.ejercicio01;

import java.net.Socket;

public class ServidorHiloEjercicio01 extends Thread{
	private Socket socket;
	
	public ServidorHiloEjercicio01(Socket socket) {
			super();
			this.socket = socket;
		}
	
	@Override
	public void run() {
		try {
			System.out.println("Conexión establecida en "+socket.getInetAddress());
			sleep(5000);
			System.out.println("Conexión finalizada");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
