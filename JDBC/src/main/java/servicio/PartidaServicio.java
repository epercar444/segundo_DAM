package servicio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Partida;
import repositorio.PartidaRepositorio;
import utils.MiExcepcion;
import utils.TipoResultado;


public class PartidaServicio {
	private static final Logger logger = LogManager.getLogger(PartidaServicio.class);
	private PartidaRepositorio repositorio;
	public PartidaRepositorio getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(PartidaRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	public PartidaServicio() {
		super();
		try {
			this.repositorio = new PartidaRepositorio();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addPartida (Partida p) {
		int filas = 0;
		try {
			filas = repositorio.addPartido(p);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return filas;
	}
	
	public int updatePuntNarrados (int id,TipoResultado tipoResultado) {
		return repositorio.updatePuntNarrador(id, tipoResultado);
	}
	
	public int updateNOAcertantes (int id,TipoResultado tipoResultado) {
		return repositorio.updateNOAcertante(id, tipoResultado);
	}
	
	public int updateAcertante (int id,TipoResultado tipoResultado) {
		return repositorio.updateAcertante(id, tipoResultado);
	}
	
	public List<Partida> getPartidasXDate () {
		return repositorio.getPartidasXDate();
	}
	
}
