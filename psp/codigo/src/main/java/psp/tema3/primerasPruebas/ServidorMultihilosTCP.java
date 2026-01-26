package psp.tema3.primerasPruebas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMultihilosTCP {
	//servidor que acepta la petición pero para hablar con el servidor llama a la clase indicada para eso
	public static void main(String[] args) {
    int puerto = 6000;
    try (ServerSocket servidor = new ServerSocket(puerto)) {
        System.out.println("Servidor multihilo iniciado en el puerto " + puerto);
        while (true) {
            // 1. Espera a un cliente
            Socket socketCliente = servidor.accept();
            System.out.println("Nuevo cliente conectado: " + socketCliente.getInetAddress());
            // 2. Lanza un hilo nuevo para este cliente específico
            // Esto permite que el bucle vuelva al accept() inmediatamente
            new ServidorHilo(socketCliente).start();
        }
    } catch (IOException e) {
        System.err.println("Error en el servidor: " + e.getMessage());
    }
}
}
