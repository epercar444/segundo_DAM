package psp.tema2.boletin2;

import java.util.ArrayList;
import java.util.List;

public class GestionaVocales {
	
	public static void main(String[] args) {
		String texto = "En un amanecer tranquilo, las montañas despertaron cubiertas de luz dorada. El viento suave llevó consigo historias antiguas, susurradas entre hojas y ríos. Cada paso revelaba nuevos matices de belleza, invitando a contemplar el paisaje con asombro sereno y gratitud profunda, que llenaba el corazón de calma y renovada esperanza.";
		VocalesTotales claseVocales = new VocalesTotales(0);
		
		List<Thread> hilos = new ArrayList<>();
		String[] vocales = {"a","e","i","o","u"};
		
		for (String i : vocales) {
			CuentaVocalHilo hilo = new CuentaVocalHilo(i, texto,0);
			Thread hiloThread = new Thread(hilo);
			hilos.add(hiloThread);
		}
		
		for (Thread h : hilos) {
			h.start();
		}
		
		for (Thread h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				System.out.println(claseVocales.getContador());
			}
		}
	}
}
