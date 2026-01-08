package repaso1MVC.repositorio;

import java.time.LocalDate;

import repaso1MVC.exception.ConversacionException;
import repaso1MVC.modelo.Conversacion;
import repaso1MVC.modelo.TipoAgente;

public interface IRepositorioConversaciones {
	public void agregaConversacion(TipoAgente tipo, String pregunta,
			String respuesta);
			
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipo,
	String pregunta) throws ConversacionException;
			
	public boolean contieneConversacionConversacion(Conversacion
	conversacion);
	
	public void eliminaConversacion(LocalDate fecha, TipoAgente
	tipo, String pregunta) throws ConversacionException;
			
	public Conversacion incrementaNumeroValoraciones(LocalDate fecha,
	TipoAgente tipo, String pregunta) throws
	ConversacionException;

	void agregaConversacion(TipoAgente tipo, String pregunta, String respuesta, int id);
			
}

