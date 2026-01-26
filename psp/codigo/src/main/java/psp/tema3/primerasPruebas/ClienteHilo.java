package psp.tema3.primerasPruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHilo extends Thread{
	//cliente sin main para que se lance muchas veces
	@Override
	public void run() {
		String host = "localhost";
		int puerto = 6000; //

		try (Socket socket = new Socket(host, puerto); // Conexión
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true); //
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); //
				Scanner sc = new Scanner(System.in)) { //

			System.out.println("Cliente : Conectado al servidor.");

			// Leemos el saludo inicial del servidor multihilo
			String saludo = entrada.readLine();
			System.out.println("Servidor dice: " + saludo);

			String textoUsuario = "";

			// BUCLE: Mientras no escribas "fin", el cliente sigue vivo
			while (!textoUsuario.equalsIgnoreCase("fin")) {
				System.out.print("Escribe un mensaje (o 'fin' para salir): ");
				textoUsuario = sc.nextLine();

				// 1. Enviamos al servidor
				salida.println(textoUsuario);

				// 2. Leemos la respuesta
				String respuesta = entrada.readLine();
				System.out.println("Respuesta del servidor: " + respuesta);
			}

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Cliente : Conexión cerrada.");
	}

}
