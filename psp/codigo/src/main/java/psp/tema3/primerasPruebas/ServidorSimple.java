package psp.tema3.primerasPruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSimple {
	public static void main(String[] args) {
		//1.Definimos el puerto (identifica la aplicación en la máquina)
		int puerto = 6000;
		ServerSocket servidor = null;
		Socket clienteConectado = null;
		
		//2.Crear el ServerSocket para escuchar peticiones
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor : Servidor escuchando en el puerto " + puerto);
			//Acepto comunicarme y devuelvo el socket del cliente
			Socket cliente = servidor.accept();
			System.out.println("Servidor : Nuevo cliente conectado: " + cliente.getInetAddress());
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
			
			String mensaje = entrada.readLine();
			System.out.println("Servidor : Cliente dice: "+mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
