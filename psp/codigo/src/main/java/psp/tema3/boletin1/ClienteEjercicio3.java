package psp.tema3.boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteEjercicio3 {
	public static void main(String[] args) {
		String Host = "localhost"; //host servidor con el que el cliente quiere conectarse
		int Puerto = 6000;//puerto remoto en el servidor que el cliente conoce         
		Socket cliente = null;
		try {
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente : conexión establecida");
			
			//3.Configurar flujos para enviar y recibir datos
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String mensajeServidor = "";
			
			while (!mensajeServidor.equalsIgnoreCase("Fin")) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Introduce un mensaje: ");
				mensajeServidor = sc.nextLine();
				//4.Enviar mensaje al servidor
				salida.println(mensajeServidor);
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
