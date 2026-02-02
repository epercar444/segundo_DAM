package examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import examen.Cliente.CANDIDATO;

public class ClienteHilo extends Thread{
	//cliente sin main para que se lance muchas veces
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		String host = "localhost";
		int puerto = 5555; 
		
		try {
			Socket socket = new Socket(host, puerto); 
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true); 
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			
			System.out.println("Cliente : Conectado al servidor.");
			String candidato = generaVotoCandidato();
			int dni = generaVotoDNI();
			String textoUsuario = dni+":::"+candidato;
			salida.println(textoUsuario);
			String respuesta = entrada.readLine();
			System.out.println(respuesta);
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Cliente : Conexión cerrada.");
	}
	
	public enum CANDIDATO {ANA,BORJA,CARLA};
	
	public static String generaVotoCandidato() {
		Random r = new Random();
		CANDIDATO [] valores = CANDIDATO.values();
		int pos = r.nextInt(valores.length);
		return valores[pos].name();
	}
	
	public static int generaVotoDNI () {
		Random r = new Random();
		int aleatorio = r.nextInt(101);
		return aleatorio;
	}
}
	

