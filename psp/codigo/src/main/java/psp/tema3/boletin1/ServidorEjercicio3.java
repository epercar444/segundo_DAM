package psp.tema3.boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEjercicio3 {
	    public static void main(String[] args) {
	        int puerto = 6000;
	        ServerSocket servidor = null;
	        try {
	            servidor = new ServerSocket(puerto);
	            System.out.println("Servidor iniciado. Esperando a los clientes.");
	            // Bucle para atender a 3 clientes
	            for (int i = 1; i <= 3; i++) {
	                System.out.println("Esperando al cliente número " + i);
	                // Acepta la conexión de un solo cliente
	                Socket clienteConectado = servidor.accept();
	                System.out.println("Cliente " + i + " conectado.");
	                // Configurar flujo de salida para enviar el número
	                PrintWriter salida = new PrintWriter(clienteConectado.getOutputStream(), true);
	                // Enviar el número de cliente
	                salida.println("Eres el cliente número " + i);
	                // Cerrar la conexión con este cliente antes de pasar al siguiente
	                clienteConectado.close();
	                System.out.println("Cliente " + i + " atendido y desconectado.");
	            }

	            System.out.println("Se han atendido los 3 clientes. Cerrando servidor.");

	        } catch (IOException e) {
	            System.err.println("Error: " + e.getMessage());
	        } finally {
	            try {
	                if (servidor != null) servidor.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

