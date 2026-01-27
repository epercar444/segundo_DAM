package psp.tema3.boletin2.ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHiloEjercicio5 extends Thread{
    Socket socket;
    NumSecreto numerito;
    EstadoNum estado;

    public ServidorHiloEjercicio5(Socket socket,NumSecreto numerito) {
        super();
        this.socket = socket;
        this.numerito = numerito;
        this.estado = estado;
    }

    @Override
    public void run() {
        try {
            // no cierra sesión cuando se adivina
            int numSecreto = numerito.numSecreto; 
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.println("Bienvenido. El número secreto es: " + numSecreto);
            
            String mensaje;
            // El bucle ahora también mira si alguien ha acertado ya
            while (!numerito.acertado && (mensaje = entrada.readLine()) != null) {
                int intento = Integer.parseInt(mensaje);
                
                if (intento == numSecreto) {
                    salida.println(EstadoNum.ACIERTO);
                    numerito.acertado = true; // ESTO CIERRA LAS DEMÁS SESIONES
                } else if (intento > numSecreto) {
                    salida.println(EstadoNum.MAYOR);
                } else {
                    salida.println(EstadoNum.MENOR);
                }
            }

            // Si salimos del bucle porque otro acertó, avisamos antes de cerrar
            if (numerito.acertado) {
                salida.println("SESION_CERRADA: Alguien ha acertado el número.");
            }
            
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	}

    

