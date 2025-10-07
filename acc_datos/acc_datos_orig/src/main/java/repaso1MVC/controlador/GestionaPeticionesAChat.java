package repaso1MVC.controlador;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repaso1MVC.modelo.Conversacion;
import repaso1MVC.modelo.TipoAgente;
import repaso1MVC.servicio.ServicioConversaciones;


public class GestionaPeticionesAChat {
	private static final Logger logger = LogManager.getLogger(GestionaPeticionesAChat.class);

	public static void main(String[] args) {
		ServicioConversaciones servicio = new ServicioConversaciones();
		Conversacion c1 = new Conversacion(1, "¿Cuál es el horario de atención?", "Nuestro horario es de 9 a 18 horas.", 10, LocalDate.of(2024, 4, 10), TipoAgente.HUMANO);
		Conversacion c2 = new Conversacion(2, "¿Cómo puedo cambiar mi contraseña?", "Puedes cambiar tu contraseña desde la configuración de tu cuenta.", 5, LocalDate.of(2024, 3, 25), TipoAgente.HUMANO);
		Conversacion c3 = new Conversacion(3, "¿Qué métodos de pago aceptan?", "Aceptamos tarjetas de crédito y débito, además de PayPal.", 7, LocalDate.of(2024, 5, 1), TipoAgente.IA);
		
		
		servicio.registraNuevaConveracion(c1.getAgente(),c1.getPregunta(),c1.getRespuesta(),c1.getId());
		servicio.registraNuevaConveracion(TipoAgente.IA, "¿Qué es una clase?", "Una clase es un plano para objetos",2);
		logger.info("Conversaciones añadidas: " + servicio.getRepo().getConversaciones());
		
		
		logger.info("GetConversacion: "+ servicio.getRecuperaConversacion(TipoAgente.IA, "¿Qué es una clase?", null));
		

	}

}
