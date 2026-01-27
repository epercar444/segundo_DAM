package psp.tema3.boletin2.ejercicio4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

import psp.tema3.boletin2.ejercicio2.ServidorHiloEjercicio2;

public class ServidorEjercicio4 {
	public static void main(String[] args) {
		Contador contador = new Contador();
		Tablero tablero = new Tablero();
	    int puerto = 6666;
	    try (ServerSocket servidor = new ServerSocket(puerto)) {
	        System.out.println("Servidor multihilo iniciado en el puerto " + puerto);
	        System.out.println("Posiciones con premio: [0, 0], [1, 2], [2, 0], [2, 3]");
	        while (true) {
	            // 1. Espera a un cliente
	            Socket socketCliente = servidor.accept();
	            // 2. Lanza un hilo nuevo para este cliente específico
	            // Esto permite que el bucle vuelva al accept() inmediatamente
	            new ServidorHiloEjercicio4(socketCliente,contador,tablero).start();
	        }
	    } catch (IOException e) {
	        System.err.println("Error en el servidor: " + e.getMessage());
	    }
	}
}
