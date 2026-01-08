package repaso1MVC.servicio;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repaso1MVC.exception.ConversacionException;
import repaso1MVC.modelo.Conversacion;
import repaso1MVC.modelo.TipoAgente;
import repaso1MVC.repositorio.RepositorioConversaciones;

public class ServicioConversaciones implements IServicioConversaciones{
	RepositorioConversaciones repo;
	private static final Logger logger = LogManager.getLogger(IServicioConversaciones.class);

	public ServicioConversaciones() {
		super();
		this.repo = new RepositorioConversaciones();
	}

	public RepositorioConversaciones getRepo() {
		return repo;
	}


	public void setRepo(RepositorioConversaciones repo) {
		this.repo = repo;
	}


	@Override
	public void registraNuevaConveracion(TipoAgente tipo, String pregunta, String respuesta,int id) {
		repo.agregaConversacion(tipo, pregunta, respuesta,id);
		
	}

	@Override
	public Conversacion getRecuperaConversacion(TipoAgente tipo, String pregunta, LocalDate fecha) {
		Conversacion c = null;
		try {
			c = repo.getConversacion(fecha, tipo, pregunta);
		} catch (ConversacionException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
		return c;
	}

	@Override
	public void eliminaConversacion(LocalDate fecha, TipoAgente tipo,String pregunta) {
		try {
			repo.eliminaConversacion(fecha, tipo, pregunta);
		} catch (ConversacionException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
	}

	@Override
	public Conversacion incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta) {
		Conversacion p = null;
		try {
			p = repo.incrementaNumeroValoraciones(fecha, tipo, pregunta);
		} catch (ConversacionException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
		return p;
	}

	@Override
	public double getValoracionMediaParaHumanos() {
		double valor_humano = 0;
		double contador = 0;
		for (Conversacion c : repo.getConversaciones()) {
			contador++;
			if (c.getAgente().equals(TipoAgente.HUMANO)) {
				valor_humano++;
			}
		}
		double valor_media = valor_humano/contador;
		return valor_media;
	}

	@Override
	public double getValoracionMedidaParaBots() {
		double valor_bot = 0;
		double contador = 0;
		for (Conversacion c : repo.getConversaciones()) {
			contador++;
			if (c.getAgente().equals(TipoAgente.IA)) {
				valor_bot++;
			}
		}
		double valor_media = valor_bot/contador;
		return valor_media;
	}

	@Override
	public void registraNuevaConveracion(TipoAgente tipo, String pregunta, String respuesta) {
		// TODO Auto-generated method stub
		
	}

}
