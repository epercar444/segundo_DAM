package psp.tema2.simulacro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaTaller2 {
    public static void main(String[] args) {
        Semaphore hayCoches = new Semaphore(20);
        Semaphore hayTurno = new Semaphore(2); 
        
        
        try {
            // Simplemente bloqueamos los 20 permisos de hayCoches que dimos inicialmente.
            // Esto es para que los coches lleguen y llamen a hayCoches.release() 
            // y los mecánicos llamen a hayCoches.acquire().
            // Pero como estamos siguiendo tu modelo, mantendremos la llegada de coche
            // como un release, y el inicio de la reparación como un acquire.
            hayCoches.acquire(20);
            hayTurno.acquire(2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Thread> hilosCoche = new ArrayList<Thread>();
        System.out.println("--- INICIO DE LA JORNADA CON DOS MECÁNICOS ---");
        long inicio = System.currentTimeMillis();
       
     // Crear y ejecutar los dos hilos Mecánico
               //Mecánico 1: Tarda 5 segundos (5000 ms)
        		Mecanico2 mecanico1 = new Mecanico2("Mecanico 1 (5s)", hayCoches, hayTurno, 5000);
        		//Mecánico 2: Tarda 8 segundos (8000 ms)
        		Mecanico2 mecanico2 = new Mecanico2("Mecanico 2 (8s)", hayCoches, hayTurno, 8000);
         
        		Thread hiloMecanico1 = new Thread(mecanico1);
        		Thread hiloMecanico2 = new Thread(mecanico2);
       
        		hiloMecanico1.start();
        		hiloMecanico2.start();
        
        //Coches
        for (int i = 1; i <= 20; i++) {
            Coche coche = new Coche("Coche " + i, hayCoches, hayTurno);
            //Me creo hilo coches
            Thread hiloCoches = new Thread(coche);
            //Lo inicio
           hiloCoches.start();
           hilosCoche.add(hiloCoches);
        }
        

        // Esperamos a que terminen los 20 coches
        try {
        	for (Thread hilo : hilosCoche) {
        		hilo.join();
        		 }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long fin = System.currentTimeMillis();
        double tiempoTotal = (fin - inicio) / 1000.0;
        System.out.printf("Tiempo total de reparación de %d coches: %.2f segundos\n", 20, tiempoTotal);
       
        // Nota: El bucle while(true) de Mecanico2.java hará que los hilos Mecánico nunca terminen
        // porque siempre estarán esperando un coche. Para una terminación limpia, 
        // Mecanico2.java necesitaría un cambio para limitar el trabajo.
	}
 }