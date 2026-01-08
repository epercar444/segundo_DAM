package xml.SimulacionF1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.SimulacionF1.modelo.Equipo;
import xml.SimulacionF1.modelo.Piloto;
import xml.SimulacionF1.repositorio.EquipoRepo;
import xml.SimulacionF1.utils.EscrituraJSON;
import xml.SimulacionF1.utils.EscrituraXML;
import xml.SimulacionF1.utils.NotExistException;
import xml.SimulacionF1.utils.domEquipo;


public class EquipoServ {
	private static final Logger logger = LogManager.getLogger(EquipoServ.class);

	private EquipoRepo repositorio;
	private domEquipo domEquipo;
	private EscrituraJSON escrituraJson;
	private EscrituraXML escrituraXML;
	
	
	public EquipoServ(List<Equipo> equipos) {
		super();
		this.repositorio = new EquipoRepo(equipos);
		this.domEquipo = new domEquipo();
		this.escrituraJson = new EscrituraJSON();
		this.escrituraXML = new EscrituraXML();
	}
	
	public void addEquipo (Equipo e) {
		try {
			repositorio.addEquipo(e);
		} catch (NotExistException e1) {
			// TODO Auto-generated catch block
			logger.info(e1.getMessage());
		}
	}
	
	public Equipo readEquipo (int id) {
		Equipo e = null;
		try {
			e = repositorio.readEquipo(id);
		} catch (NotExistException e1) {
			// TODO Auto-generated catch block
			logger.info(e1.getMessage());
		}
		return e;
	}
	
	public void addPilotoAEquipo (Piloto p,int id) {
		try {
			repositorio.addPilotoAEquipo(p, id);
		} catch (NotExistException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public Equipo getEquipoXId (int id) {
		Equipo e = null;
		try {
			e = repositorio.buscaPorId(id);
		} catch (NotExistException e1) {
			// TODO Auto-generated catch block
			logger.info(e1.getMessage());
		}
		return e;
	}
	
	public List<Piloto> readPilotoXEquipo (int id) {
		List<Piloto> pilotos = null;
		try {
			pilotos = repositorio.readPilotosEquipo(id);
		} catch (NotExistException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return pilotos;
	}
	
	public List<Equipo> leerEquipoDesdeXML (String rutaFichero){
		List<Equipo> equipos = null;
		try {
			equipos = domEquipo.leerEquiposDesdeXML(rutaFichero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
	}
		return equipos;
	
	}
	
	public void rellenaListaPilotos(List<Equipo> equipos, List<Piloto> pilotos) {
	    for (Equipo e : equipos) {
	        List<Piloto> pilotosEquipo = new ArrayList<>();
	        int idEquipo = e.getId();
	        for (Piloto p : pilotos) {
	            if (p.getIdEquipo() == idEquipo) {
	                pilotosEquipo.add(p);
	            }
	        }
	        e.setPilotos(pilotosEquipo);
	    }
	}
	
	public List<Piloto> pilotoMayorPuntuacionQue (int puntuacion,List<Piloto> pilotos) {
		List<Piloto> piloto_mayor_puntuacion_que = new ArrayList<>();
		for (Piloto p : pilotos) {
			if (p.getPuntos() >  puntuacion) {
				piloto_mayor_puntuacion_que.add(p);
			}
		}
		return piloto_mayor_puntuacion_que;
	}

	public void escrituraJSON (String rutaFichero,List<Piloto> pilotos) {
		escrituraJson.escrituraJson(rutaFichero, pilotos);
	}
	
	public void escrituraXML (String rutaFichero,List<Equipo> equipos) {
		escrituraXML.escribeProductosEnXML(rutaFichero, equipos);
	}
}
