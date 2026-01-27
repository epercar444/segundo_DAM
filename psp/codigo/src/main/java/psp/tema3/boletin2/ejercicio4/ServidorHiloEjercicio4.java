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
    }

    @Override
    public void run() {
        this.idActual = contador.contadorId();
        System.out.println("Cliente conectado => " + idActual);
        
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {
            
            String mensaje;
            boolean continuar = true; 
            
            while (continuar && (mensaje = entrada.readLine()) != null) {
                
                if (mensaje.equalsIgnoreCase("n")) {
                    salida.println("Cerrando sesión. ¡Hasta pronto!");
                    continuar = false; 
                } else {
                    try {
                        String[] mensaje_split = mensaje.split(","); 
                        int fila = Integer.parseInt(mensaje_split[0].trim()); 
                        int columna = Integer.parseInt(mensaje_split[1].trim()); 
                        
                        System.out.println("Cliente " + idActual + " pide: " + mensaje);
                        
                        
                        String resultado = tienePremio(fila, columna);
                        
                        
                        if (!quedanPremios()) {
                        	salida.println(resultado);
                            salida.println("No quedan más premios. Desconectando...");
                            System.out.println("Cerrando conexión de cliente " + idActual);
                            continuar = false; 
                        } else {
                            salida.println(resultado);
                        }
                        if (!continuar) {
                        	socket.close();
                        }
                        
                    } catch (Exception e) {
                        salida.println("Error: Formato incorrecto. Usa 'fila,columna'.");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el hilo " + idActual + ": " + e.getMessage()); 
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                    System.out.println("Cliente desconectado => " + idActual);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    private synchronized boolean quedanPremios() {
    	boolean quedan = false;
        for (int i = 0; i < tablero.getTablero().length; i++) {
            for (int j = 0; j < tablero.getTablero()[i].length; j++) {
                if (tablero.getTablero()[i][j] != null) {
                    quedan = true;
                }
            }
        }
        return quedan; 
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