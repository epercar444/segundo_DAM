package psp.tema3.boletin2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEjercicio0 {
	public static void main(String[] args) {
		// 1. Definir el puerto (identifica la aplicación en la máquina)
		int puerto = 5555;
		ServerSocket servidor = null;
		Socket clienteConectado = null;

		try {
		    // 2. Crear el ServerSocket para escuchar peticiones
		    servidor = new ServerSocket(puerto);
		    System.out.println("Servidor escuchando en el puerto " + puerto);
		    while (true) {
	               // 1. Espera a un cliente
	               Socket socketCliente = servidor.accept();
	               System.out.println("Nuevo cliente conectado: " + socketCliente.getInetAddress());
	               BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
	               String mensaje = entrada.readLine();

	               // 2. Lanza un hilo nuevo para este cliente específico
	               // Esto permite que el bucle vuelva al accept() inmediatamente
	               new HiloAtiendeCliente(socketCliente).start();
	           }

		} catch (IOException e) {
		    // Manejo de excepciones de entrada/salida o errores de red
		    System.err.println("Error en el servidor: " + e.getMessage());
		    e.printStackTrace();
		} finally {
		    // 5. Cerrar recursos siempre para liberar el puerto
		    try {
		        if (clienteConectado != null)
		            clienteConectado.close();
		        if (servidor != null)
		            servidor.close();
		        System.out.println("Recursos cerrados y servidor finalizado.");
		    } catch (IOException e) {
		        System.err.println("Error al cerrar sockets: " + e.getMessage());
		    }
		}
		
	}
}
