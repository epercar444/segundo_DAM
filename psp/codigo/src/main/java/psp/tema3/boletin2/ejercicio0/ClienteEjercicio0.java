 package psp.tema3.boletin2.ejercicio0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteEjercicio0 extends Thread{
	public static void main(String[] args) {
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
