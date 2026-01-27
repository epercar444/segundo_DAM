package psp.tema3.boletin2.ejercicio5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ServidorEjercicio5 {
	public static void main(String[] args) {
	    int puerto = 6666;
	    NumSecreto numerito = new NumSecreto();
	    try (ServerSocket servidor = new ServerSocket(puerto)) {
	        System.out.println("Servidor multihilo iniciado en el puerto " + puerto);
	        while (true) {
	            Socket socketCliente = servidor.accept();
	            new ServidorHiloEjercicio5(socketCliente,numerito).start();
	        }
	    } catch (IOException e) {
	        System.err.println("Error en el servidor: " + e.getMessage());
	    }
	}
}
