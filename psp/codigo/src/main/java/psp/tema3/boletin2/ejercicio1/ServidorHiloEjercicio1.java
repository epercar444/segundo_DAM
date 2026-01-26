package psp.tema3.boletin2.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHiloEjercicio1 extends Thread{
	private Socket socket;
	
	public ServidorHiloEjercicio1(Socket socket) {
			super();
			this.socket = socket;
		}
	
	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			String mensaje;
			while ((mensaje = entrada.readLine()) != null) {
					System.out.println("Cliente dice: " + mensaje);
					salida.println("ECO: " + mensaje);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
