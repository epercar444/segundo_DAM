package repaso1MVC.controlador;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ejemplo.controlador.ProbandoLog;
import repaso1MVC.modelo.Conversacion;
import repaso1MVC.modelo.TipoAgente;
import repaso1MVC.servicio.ServicioConversaciones;

public class GestionaPeticionesAChat {
	private static final Logger logger = LogManager.getLogger(ProbandoLog.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServicioConversaciones serv = new ServicioConversaciones();
		serv.registraNuevaConveracion(TipoAgente.IA, "¿Cuál es la capital de Francia?", "La capital de Francia es París.");
		logger.debug("Conversacion añadida: " + serv.getRepo().getConversaciones());
	}

}
