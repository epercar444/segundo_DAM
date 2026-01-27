package psp.tema3.boletin2.ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHiloEjercicio4 extends Thread {
	Socket socket;
	Contador contador;
	Tablero tablero;
	int idActual;

	public ServidorHiloEjercicio4(Socket socket, Contador contador, Tablero tablero) {
		super();
		this.socket = socket;
		this.contador = contador;
		this.tablero = tablero;
		this.idActual = idActual;
	}

	@Override
	public void run() {
		this.idActual = contador.contadorId();
		System.out.println("Cliente conectado => " + idActual);
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			String mensaje;
			boolean continuar = true;
			
			while (quedanPremios() && (mensaje = entrada.readLine()) != null && !mensaje.equalsIgnoreCase("n")) {
				if (!quedanPremios()) {
						salida.println("Lo siento, no quedan más premios. Cerrando sesión.");
						System.out.println("No quedan premios. Cliente desconectado => " + idActual);
						continuar = false;
					}
			else {
					String[] mensaje_split = mensaje.split(",");
					int fila = Integer.parseInt(mensaje_split[0].trim());
					int columna = Integer.parseInt(mensaje_split[1].trim());
					
					System.out.println("Cliente dice: " + mensaje);
					salida.println(tienePremio(fila, columna));
				
			if (!quedanPremios()) {
				System.out.println("No quedan más premios. Cliente desconectado => " + idActual);
				continuar = false;
			}
			}
				
		
		if (continuar && mensaje != null && mensaje.equalsIgnoreCase("n")) {
			salida.println("Cerrando sesión. ¡Hasta pronto!");
			System.out.println("Cliente desconectado => " + idActual);
		}

			socket.close();
			}
		}catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	private boolean quedanPremios() {
		boolean quedanPremios = false;
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if (tablero.getTablero()[i][j] != null) {
					quedanPremios = true;
				}
			}
		}
		return quedanPremios;
	}

	private synchronized String tienePremio(int fila, int columna) {
		String hayPremio = "";
		if (fila >= 0 && fila < 3 && columna >= 0 && columna < 4) {
			if (tablero.getTablero()[fila][columna] != null) {
				hayPremio = "¡Enhorabuena! Has conseguido " + tablero.getTablero()[fila][columna];
				tablero.getTablero()[fila][columna] = null;
			} else {
				hayPremio = "Lo siento. Sigue intentándolo.";
			}
		} else {
			hayPremio = "Coordenadas fuera de rango.";
		}
		return hayPremio;
	}
}