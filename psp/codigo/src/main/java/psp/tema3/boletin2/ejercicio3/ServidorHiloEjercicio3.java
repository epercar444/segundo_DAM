package psp.tema3.boletin2.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHiloEjercicio3 extends Thread{
	//servidor que habla realmente con el cliente
	Contador contador;
	Socket socket;
	
	public ServidorHiloEjercicio3(Socket socket,Contador contador) {
		super();
		this.contador = contador;
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			salida.println("Bienvenido. Eres el cliente número "+contador.contadorSuma());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
