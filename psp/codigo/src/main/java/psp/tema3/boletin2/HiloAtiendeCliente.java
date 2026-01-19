package psp.tema3.boletin2;

import java.net.Socket;

public class HiloAtiendeCliente extends Thread{
	private Socket socket;
	
	public HiloAtiendeCliente(Socket socket) {
			super();
			this.socket = socket;
		}
	
	@Override
	public void run() {
		try {
			System.out.println("Cliente adquirido");
			sleep(3000);
			System.out.println("Cliente atendido");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
