package psp.tema3.boletin2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteEjercicio0 extends Thread{
	 @Override
	public void run() {
			// 1. Definir el host y el puerto del servidor
		String host = "localhost"; // IP de la propia máquina
		int puerto = 5555;

		Socket socket = null;
		try {
			socket = new Socket(host, puerto);
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			salida.println("¡Conexión establecida!");

		} catch (UnknownHostException e) {
		    System.err.println("No se puede encontrar el host: " + host);
		} catch (IOException e) {
		    System.err.println("Error de entrada/salida: " + e.getMessage());
		} finally {
		    // 6. Cerrar el socket del cliente para liberar recursos
		    try {
		        if (socket != null) {
		            socket.close();
		            System.out.println("Conexión cerrada.");
		        }
		    } catch (IOException e) {
		        System.err.println("Error al cerrar el cliente: " + e.getMessage());
		    }
		}
	}

}
