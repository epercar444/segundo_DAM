package xml.SimulacionF1.repositorio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.SimulacionF1.modelo.Equipo;
import xml.SimulacionF1.modelo.Piloto;
import xml.SimulacionF1.utils.NotExistException;
import xml.primerBoletin.repositorio.PeliculaRepo;

public class EquipoRepo {
    private static final Logger logger = LogManager.getLogger(EquipoRepo.class);

	private List<Equipo> equipos;

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public EquipoRepo(List<Equipo> equipos) {
		super();
		this.equipos = new ArrayList<>();
	}
	
	public Equipo buscaPorId (int id) throws NotExistException {
		Equipo e_unico = null;
		for (Equipo e : equipos) {
			if (e.getId() == id) {
				e_unico = e;
			}
			else {
				throw new NotExistException("El equipo no existe en la lista");
			}
		}
		return e_unico;
	}
	
	public void addEquipo (Equipo e) throws NotExistException {
		if (!equipos.contains(e)) {
			equipos.add(e);
		}
		else {
			throw new NotExistException("El equipo ya existe en la lista");
		}
	}
	
	public Equipo readEquipo (int id) throws NotExistException {
		Equipo e_unico = null;
		Equipo e = buscaPorId(id);
		if (!e.equals(null)) {
			e_unico = e;
		}
		return e_unico;
	}
	
	public void addPilotoAEquipo (Piloto p, int id) throws NotExistException {
		Equipo e = buscaPorId(id);
		List<Piloto> pilotos = e.getPilotos();
		for (Piloto p1 : pilotos) {
			if (!p1.equals(p)) {
				pilotos.add(p);
			}
			else {
				throw new NotExistException("El piloto ya existe en la lista");
			}
		}
		
	}
	
	public List<Piloto> readPilotosEquipo (int id) throws NotExistException {
		List<Piloto> pilotos = new ArrayList<>();
		Equipo e = buscaPorId(id);
		if (!e.equals(null)) {
			pilotos = e.getPilotos();
		}
		return pilotos;
	}
	
	
}
