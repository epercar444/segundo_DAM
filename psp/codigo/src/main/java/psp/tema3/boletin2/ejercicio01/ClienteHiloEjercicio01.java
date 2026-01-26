package psp.tema3.boletin2.ejercicio01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHiloEjercicio01 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		String host = "localhost";
		int puerto = 5555; 

		try (Socket socket = new Socket(host, puerto); // Conexión
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true); 
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
				Scanner sc = new Scanner(System.in)) { //

			System.out.println("Cliente : Conectado al servidor.");

			// Leemos el saludo inicial del servidor multihilo
			String saludo = entrada.readLine();
			System.out.println("Servidor dice: " + saludo);

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Cliente : Conexión cerrada.");
	}
	}


