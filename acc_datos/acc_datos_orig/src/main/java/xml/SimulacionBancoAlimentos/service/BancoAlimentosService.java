package xml.SimulacionBancoAlimentos.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.SimulacionBancoAlimentos.modelo.CentroLogistico;
import xml.SimulacionBancoAlimentos.modelo.Trabajador;
import xml.SimulacionBancoAlimentos.repositorio.BancoAlimentosRepo;
import xml.SimulacionBancoAlimentos.utils.BancoException;
import xml.SimulacionBancoAlimentos.utils.TipoTrabajador;
import xml.SimulacionBancoAlimentos.utils.leeXML;

public class BancoAlimentosService {
	private static final Logger logger = LogManager.getLogger(BancoAlimentosService.class);
	private BancoAlimentosRepo repositorio;
	private leeXML lectorXML;

	public BancoAlimentosService(List<CentroLogistico> centros) {
		super();
		this.repositorio = new BancoAlimentosRepo(centros);
		this.lectorXML = new leeXML();
	}
	
	public void addCentroLogistico (CentroLogistico c) {
		try {
			repositorio.addCentroLogistico(c);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public void addTrabajadorACentro (CentroLogistico c,Trabajador t) {
		try {
			repositorio.addTrabajadorACentro(c, t);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public CentroLogistico readCentroLogistico (int id) {
		CentroLogistico c = null;
		try {
			c = repositorio.readCentroLogistico(id);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return c;
	}
	
	public Trabajador readTrabajadorXCentroLosgistico (String dni) {
		Trabajador t = null;
		try {
			t = repositorio.readTrabajador(dni);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return t;
	}
	
	public List<CentroLogistico> leeXML (String ruta) {
		List<CentroLogistico> centros = new ArrayList<>();
		try {
			centros = lectorXML.leerCentrosDesdeXML(ruta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return centros;
	}
	
	public List<Trabajador> trabajadoresPorTipo (TipoTrabajador tipo,List<CentroLogistico> centros) {
		List<Trabajador> trabajadoresTipo = new ArrayList<>();
		for (CentroLogistico c : centros) {
			List<Trabajador> trabajadores = c.getTrabajadores();
			for (Trabajador t : trabajadores) {
				if(t.getTipo().equals(tipo)) {
					trabajadoresTipo.add(t);
				}
			}
		}
		return trabajadoresTipo;
	}
	
	public CentroLogistico getCentroXTrabajador (Trabajador t) {
		
	}
	
	
	
}
