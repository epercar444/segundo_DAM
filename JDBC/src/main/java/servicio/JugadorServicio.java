package servicio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Jugador;
import repositorio.JugadorRepositorio;
import utils.MiExcepcion;

public class JugadorServicio {
	private static final Logger logger = LogManager.getLogger(JugadorServicio.class);
	private JugadorRepositorio repositorio;

	public JugadorRepositorio getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(JugadorRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	public JugadorServicio() {
		super();
		try {
			this.repositorio = new JugadorRepositorio();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	public void cargarJugadores() {
		repositorio.cargarJugadores();
	}
	
	public int addJugador (Jugador j) {
		return repositorio.addJugador(j);
	}
	
	public Jugador getPlayerMaxPunt () {
		return repositorio.getPlayerMaxPunt();
	}
	
	public List<Jugador> getByPuntosTotales () {
		return repositorio.getByPuntosTotales();
	}
}
