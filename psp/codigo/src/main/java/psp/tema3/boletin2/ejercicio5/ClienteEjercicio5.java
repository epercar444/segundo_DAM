package psp.tema3.boletin2.ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteEjercicio5 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6666;

        try (Socket socket = new Socket(host, puerto);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Cliente: Conectado al servidor.");
            
            String respuestaServidor = "";
            while (!respuestaServidor.contains("ACIERTO") && !respuestaServidor.contains("CERRADA")) {
                System.out.print("Dime un número: ");
                String num = sc.nextLine();
                salida.println(num);
                
                respuestaServidor = entrada.readLine();
                System.out.println(respuestaServidor);
            }

        } catch (UnknownHostException e) {
            System.err.println("No se encuentra el host: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}