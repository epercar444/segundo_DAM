package psp.tema3.boletin2.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHiloEjercicio2 extends Thread{
	private Socket socket;
	
	public ServidorHiloEjercicio2(Socket socket) {
			super();
			this.socket = socket;
		}
	
	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			System.out.println("Conecta con IP "+socket.getInetAddress()+",Puerto remoto: "+socket.getPort());
			sleep(5000);
			System.out.println("Desconecta con IP "+socket.getInetAddress()+",Puerto remoto: "+socket.getPort());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
