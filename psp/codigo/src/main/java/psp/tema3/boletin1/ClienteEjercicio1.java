package psp.tema3.boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteEjercicio1 {
	public static void main(String[] args) {
		// 1. Definir el host y el puerto del servidor
		String host = "localhost"; // IP de la propia máquina
		int puerto = 6000;

		Socket cliente = null;

		try {
		    // 2. Se crea el socket y se inicia la conexión 
		    System.out.println("Conectando al servidor en " + host + " por el puerto " + puerto + "...");
		    cliente = new Socket(host, puerto);
		    System.out.println("¡Conexión establecida!");
		    // 3. Configurar flujos para enviar y recibir datos
		    PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
		    BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		    // Usamos Scanner para que puedas escribir tú el mensaje por consola
		    Scanner sc = new Scanner(System.in);
		    System.out.print("Escribe un mensaje para el servidor: ");
		    String mensajeParaServidor = sc.nextLine();
		    // 4. Enviar mensaje al servidor
		    salida.println(mensajeParaServidor);
		    // 5. Leer la respuesta del servidor
		    String respuesta = entrada.readLine();
		    System.out.println("Respuesta del servidor: " + respuesta);
		} catch (UnknownHostException e) {
		    System.err.println("No se puede encontrar el host: " + host);
		} catch (IOException e) {
		    System.err.println("Error de entrada/salida: " + e.getMessage());
		} finally {
		    // 6. Cerrar el socket del cliente para liberar recursos
		    try {
		        if (cliente != null) {
		            cliente.close();
		            System.out.println("Conexión cerrada.");
		        }
		    } catch (IOException e) {
		        System.err.println("Error al cerrar el cliente: " + e.getMessage());
		    }
		}
		
}
}
