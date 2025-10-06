package repaso1MVC.servicio;

import java.time.LocalDate;

import repaso1MVC.exception.ConversacionException;
import repaso1MVC.modelo.Conversacion;
import repaso1MVC.modelo.TipoAgente;

public interface IServicioConversaciones {
	public void registraNuevaConveracion(TipoAgente tipo, String pregunta,
			String respuesta);
			public Conversacion getRecuperaConversacion(TipoAgente tipo, String
			pregunta, LocalDate fecha);
			public void eliminaConversacion(LocalDate fecha, TipoAgente tipo,String respuesta)
			throws ConversacionException;
			public Conversacion incrementaNumeroValoraciones(LocalDate fecha,
			TipoAgente tipo, String pregunta);
			public double getValoracionMediaParaHumanos();
			public double getValoracionMedidaParaBots();
			void registraNuevaConveracion(TipoAgente tipo, String pregunta, String respuesta, int id);
			}


