package psp.tema3.boletin2.ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteHiloEjercicio4 extends Thread {

	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6666;

		try (Socket socket = new Socket(host, puerto);
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				Scanner sc = new Scanner(System.in)) {

			System.out.println("Cliente : Conectado al servidor.");

			String textoUsuario = "";
            boolean seguirJugando = true; // Variable de control

            while (seguirJugando && !textoUsuario.equalsIgnoreCase("n")) {
                System.out.print("¿Quieres jugar? (S para coordenadas / N para salir): ");
                textoUsuario = sc.nextLine();

                if (textoUsuario.equalsIgnoreCase("s")) {
                    System.out.print("Escribe el hueco (fila,columna): ");
                    String coordenadas = sc.nextLine();
                    salida.println(coordenadas);
                    
                    String respuestaServidor = entrada.readLine();
                    System.out.println("Respuesta del servidor: " + respuestaServidor);

                    // Si el servidor envía el segundo mensaje de "No quedan premios"
                    if (entrada.ready()) {
                        String mensajeFin = entrada.readLine();
                        System.out.println(mensajeFin);
                        
                        // Si el mensaje contiene la despedida, cambiamos la variable
                        if (mensajeFin.contains("No quedan más premios")) {
                            seguirJugando = false; 
                        }
                    }
                } else if (textoUsuario.equalsIgnoreCase("n")) {
                    salida.println("n");
                    System.out.println(entrada.readLine());
                }
            }
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}