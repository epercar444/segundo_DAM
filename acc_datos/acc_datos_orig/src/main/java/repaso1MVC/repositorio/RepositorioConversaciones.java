package repaso1MVC.repositorio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import repaso1MVC.exception.ConversacionException;
import repaso1MVC.modelo.Conversacion;
import repaso1MVC.modelo.TipoAgente;

public class RepositorioConversaciones implements IRepositorioConversaciones{
	Set <Conversacion> conversaciones;
	
	public RepositorioConversaciones() {
		super();
		this.conversaciones = new HashSet<>();
	}

	public Set<Conversacion> getConversaciones() {
		return conversaciones;
	}

	public void setConversaciones(Set<Conversacion> conversaciones) {
		this.conversaciones = conversaciones;
	}


	@Override
	public void agregaConversacion(TipoAgente tipo, String pregunta, String respuesta, int id) {
		Conversacion conver = new Conversacion(id,pregunta, respuesta, tipo);
		conversaciones.add(conver);
		
	}

	@Override
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipo, String pregunta)
			throws ConversacionException {
		boolean encontrado = false;
		Conversacion p = null;
		
		Iterator<Conversacion> iterator = conversaciones.iterator();
			while (!encontrado && iterator.hasNext()) {
				Conversacion l = iterator.next();
				if (l.getAgente().equals(tipo) && l.getFecha_conversacion().equals(fecha) && l.getPregunta().equals(pregunta)) {
					p = l; 
					encontrado = true;
			}
				else {
					throw new ConversacionException ("No existe una conversación con estos datos");
				}
		}
		return p;
	}

	@Override
	public boolean contieneConversacionConversacion(Conversacion conversacion) {
		boolean contiene = false;
		if (conversaciones.contains(conversacion)) {
			contiene = true;
		}
		return contiene;
	}

	@Override
	public void eliminaConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException {
		Conversacion c = this.getConversacion(fecha, tipo, pregunta);
		conversaciones.remove(c);
		
	}

	@Override
	public Conversacion incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta)
			throws ConversacionException {
		Conversacion c = this.getConversacion(fecha, tipo, pregunta);
		int numValor_nuevo = c.getNumValoracionesPositivas() + 1;
		c.setNumValoracionesPositivas(numValor_nuevo);
		return c;
	}

	@Override
	public void agregaConversacion(TipoAgente tipo, String pregunta, String respuesta) {
		// TODO Auto-generated method stub
		
	}


		
		
	}

