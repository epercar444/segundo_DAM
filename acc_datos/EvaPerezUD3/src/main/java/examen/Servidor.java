package examen;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Servidor {
	public static void main(String[] args) {
		Servidor s = new Servidor();
		Map<String, String> votos = new HashMap<>();
	    int puerto = 5555;
	    try (ServerSocket servidor = new ServerSocket(puerto)) {
	        System.out.println("Conexión establecida en el puerto " + puerto);
	        while (!(votos.size() == 10)) {
	            // 1. Espera a un cliente
	            Socket socketCliente = servidor.accept();
	            // 2. Lanza un hilo nuevo para este cliente específico
	            // Esto permite que el bucle vuelva al accept() inmediatamente
	            new ServidorHilo(socketCliente,votos).start();
	        }
	        if (votos.size()==10) {
	        	System.out.println(votos.entrySet());
	        	System.out.println(s.getResume(votos));
	        }
	    } catch (IOException e) {
	        System.err.println("Error en el servidor: " + e.getMessage());
	    }
	}
	
	private String sumaVotos (String nombre,Map<String, String> votos) {
		int contador = 0;
		for (String voto : votos.values()) {
			if (voto.equalsIgnoreCase(nombre)) {
				contador++;
			}
		}
		String mensaje = nombre + " cuenta con " + contador + " votos";
		return mensaje;
	}
	
	private String getResume (Map<String, String> votos) {
		String resume = "";
		for (String candidato : votos.values()) {
			resume = sumaVotos(candidato, votos);
		}
		return resume;
	}
	
}
