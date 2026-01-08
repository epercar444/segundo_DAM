package xml.SimulacionBancoAlimentos.repositorio;

import java.util.ArrayList;
import java.util.List;

import xml.SimulacionBancoAlimentos.modelo.CentroLogistico;
import xml.SimulacionBancoAlimentos.modelo.Trabajador;
import xml.SimulacionBancoAlimentos.utils.BancoException;

public class BancoAlimentosRepo {
	private List<CentroLogistico> centros_logistico;

	public List<CentroLogistico> getCentros_logistico() {
		return centros_logistico;
	}

	public void setCentros_logistico(List<CentroLogistico> centros_logistico) {
		this.centros_logistico = centros_logistico;
	}

	public BancoAlimentosRepo(List<CentroLogistico> centros_logistico) {
		super();
		this.centros_logistico = centros_logistico;
	}
	
	public void addCentroLogistico (CentroLogistico c) throws BancoException {
		if (!centros_logistico.contains(c)) {
			centros_logistico.add(c);
		} 
		else {
			throw new BancoException("El centro introducido ya existe en la lista indicada");
		}
	}
	
	public void addTrabajadorACentro (CentroLogistico c, Trabajador t) throws BancoException {
		List<Trabajador> trabajador_centro = c.getTrabajadores();
		if (!trabajador_centro.contains(t)) {
			trabajador_centro.add(t);
		}
		else {
			throw new BancoException("El trabajador ya se encuentra en la lista indicada");
		}
	}
	
	public CentroLogistico readCentroLogistico (int id) throws BancoException { //búsqueda con while
		CentroLogistico centro = null;
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i < centros_logistico.size()) {
			if (centros_logistico.get(i).equals(id)) {
				encontrado = true;
				centro = centros_logistico.get(i);
			}
			else {
				i++;
			}
		}
		if (centro.equals(null)) {
			throw new BancoException("No se encuentra un centro con el id indicado");
		}
		return centro;

	}
	
	public Trabajador readTrabajador (String dni) throws BancoException {
		boolean encontrado = false;
		int i = 0;
		Trabajador t = null;
		List<Trabajador> trabajadores = new ArrayList<>();
		for (CentroLogistico c : centros_logistico) {
			trabajadores = c.getTrabajadores();
		}
		while (!encontrado && i < trabajadores.size()) {
			if (trabajadores.get(i).equals(dni)) {
				encontrado = true;
				t = trabajadores.get(i);
			}
			else {
				i++;
			}
	}
		if (t.equals(null)) {
			throw new BancoException("No se encuentra un centro con el id indicado");
		}
	return t;
	}
}
