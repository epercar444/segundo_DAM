package examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServidorHilo extends Thread{
	private Socket socket;
	Map<String,String> votos;
	
	public ServidorHilo(Socket socket,Map<String,String> votos) {
		super();
		this.socket = socket;
		this.votos = votos;
	}

	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			String mensaje = entrada.readLine();
			if (mensaje!= null) {
				System.out.println("Cliente dice: " + mensaje);
				guardaVoto(mensaje);
				salida.println("Servidor responde: Voto registrado");			
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void guardaVoto (String mensaje) {
		String[] mensaje_slip = mensaje.split(":::");
		votos.put(mensaje_slip[0].trim(), mensaje_slip[1].trim());
	}
	}

