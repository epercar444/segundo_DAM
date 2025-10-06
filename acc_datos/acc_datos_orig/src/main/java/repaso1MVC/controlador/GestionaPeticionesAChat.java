package repaso1MVC.controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repaso1MVC.modelo.Conversacion;
import repaso1MVC.modelo.TipoAgente;
import repaso1MVC.servicio.ServicioConversaciones;


public class GestionaPeticionesAChat {
	private static final Logger logger = LogManager.getLogger(GestionaPeticionesAChat.class);

	public static void main(String[] args) {
		ServicioConversaciones servicio = new ServicioConversaciones();
		/*Conversacion c1 = new Conversacion("¿Qué es Java?", "Java es un lenguaje de programación", TipoAgente.IA),
	             c2 = new Conversacion("¿Qué es una clase?", "Una clase es un plano para objetos", TipoAgente.HUMANO),
	             c3 = new Conversacion("¿Qué es JVM?", "Es la máquina virtual de Java.", TipoAgente.IA);*/
		
		
		servicio.registraNuevaConveracion(TipoAgente.HUMANO, "¿Qué es Java?", "Java es un lenguaje de programación",1);
		servicio.registraNuevaConveracion(TipoAgente.IA, "¿Qué es una clase?", "Una clase es un plano para objetos",2);
		logger.info("Conversaciones añadidas: " + servicio.getRepo().getConversaciones());
		
		
		logger.info("GetConversacion: "+ servicio.getRecuperaConversacion(TipoAgente.IA, "¿Qué es una clase?", null));
		

	}

}
