package psp.tema3.boletin2.ejercicio0;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorEjercicio0 {
	public static void main(String[] args) {
	    int puerto = 5555;
	    try (ServerSocket servidor = new ServerSocket(puerto)) {
	        System.out.println("Servidor multihilo iniciado en el puerto " + puerto);
	        while (true) {
	            // 1. Espera a un cliente
	            Socket socketCliente = servidor.accept();
	            // 2. Lanza un hilo nuevo para este cliente específico
	            // Esto permite que el bucle vuelva al accept() inmediatamente
	            new ServidorHiloEjercicio0(socketCliente).start();
	        }
	    } catch (IOException e) {
	        System.err.println("Error en el servidor: " + e.getMessage());
	    }
	}
}
