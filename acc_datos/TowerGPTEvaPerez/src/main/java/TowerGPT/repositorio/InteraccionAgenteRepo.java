package TowerGPT.repositorio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import TowerGPT.Exceptions.NotFoundException;
import TowerGPT.Exceptions.SetValidacionException;
import TowerGPT.modelo.InteraccionAgente;

public class InteraccionAgenteRepo {
	private static final Logger logger = LogManager.getLogger(InteraccionAgenteRepo.class);
	private Set<InteraccionAgente> interacciones;

	public InteraccionAgenteRepo() {
		super();
		this.interacciones = new HashSet<>();
	}
	
	public Set<InteraccionAgente> getInteracciones() {
		return interacciones;
	}


	public void setInteracciones(Set<InteraccionAgente> interacciones) {
		this.interacciones = interacciones;
	}


	public InteraccionAgente BuscaInteraccionPorId (int id){
		InteraccionAgente p = null;
		for (InteraccionAgente i : interacciones) {
			while (i.getId() == id) {
				p = i;
			}
		}
		return p;
	}
	
	public void anadirInteraccion (InteraccionAgente interaccion) {
			interacciones.add(interaccion);
		}
	
	public void eliminarInteraccion (int id) throws NotFoundException {
		InteraccionAgente interaccion = BuscaInteraccionPorId(id);
		if (!interaccion.equals(null)) {
			interacciones.remove(interaccion);
		}
		else {
			throw new NotFoundException ("La interración introducida no existe");
		}
	}
	
	public void actualizarInteraccion(InteraccionAgente nuevaInteraccion, int id) throws NotFoundException {
	    boolean actualizado = false;
	    Iterator<InteraccionAgente> iterator = interacciones.iterator();
	    while (iterator.hasNext()) {
	        InteraccionAgente actual = iterator.next();
	        if (actual.getId() == id) {
	            actual.setPorcentaje_Acierto(nuevaInteraccion.getPorcentaje_Acierto());
	            actual.setTipoAgente(nuevaInteraccion.getTipoAgente());
	            actual.setPeticion(nuevaInteraccion.getPeticion());
	            actual.setRespuesta(nuevaInteraccion.getRespuesta());
	            try {
					actual.setValoracion(nuevaInteraccion.getValoracion());
				} catch (SetValidacionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            actualizado = true;
	        }
	    }

	    if (!actualizado) {
	        throw new NotFoundException("La interacción con ID " + id + " no existe");
	    }
	}

	public void leeInteraccion (int id) throws NotFoundException {
		InteraccionAgente interaccion = BuscaInteraccionPorId(id);
		if (!interaccion.equals(null)) {
			logger.info(interaccion.toString());
		}
		else {
			throw new NotFoundException ("La interración introducida no existe");
		}
	}
	
	public int incrementaNumValoraciones () {
		int numValoraciones = 0;
		for (InteraccionAgente f : interacciones) {
				numValoraciones += 1;
			}
		return numValoraciones;
	}
	
	public int actualizaPorcentaje () {
		int numTotalInteracciones = 0;
		int totalPorcentajes = 0;
		for (InteraccionAgente f : interacciones) {
			numTotalInteracciones += 1;
			totalPorcentajes += f.getPorcentaje_Acierto();
	}
		int mediaPorcentajes = totalPorcentajes / numTotalInteracciones;
		return mediaPorcentajes;
	}
	
	}

