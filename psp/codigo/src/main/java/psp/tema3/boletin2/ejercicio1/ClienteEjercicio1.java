package psp.tema3.boletin2.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ClienteEjercicio1 {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 44444; //

		try (Socket socket = new Socket(host, puerto); // Conexión
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true); //
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); //
				Scanner sc = new Scanner(System.in)) { //

			String textoUsuario = "";

			// BUCLE: Mientras no escribas "fin", el cliente sigue vivo
			while (true) {
				System.out.print("Escribe un mensaje: ");
				textoUsuario = sc.nextLine();

				// 1. Enviamos al servidor
				salida.println(textoUsuario);

				// 2. Leemos la respuesta
				String respuesta = entrada.readLine();
				System.out.println("Servidor dice: " + respuesta);
			}

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Cliente : Conexión cerrada a las "+LocalDateTime.now());
	}
}
