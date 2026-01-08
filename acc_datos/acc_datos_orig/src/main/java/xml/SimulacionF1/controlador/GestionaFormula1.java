package xml.SimulacionF1.controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.SimulacionF1.modelo.Equipo;
import xml.SimulacionF1.modelo.Piloto;
import xml.SimulacionF1.service.EquipoServ;
import xml.SimulacionF1.utils.domEquipo;
import xml.SimulacionF1.utils.domPiloto;

public class GestionaFormula1 {
	private static final String rutaFichero = "src/main/resources/pilotos.json";
	private static final Logger logger = LogManager.getLogger(GestionaFormula1.class);
	public static void main(String[] args) {
		domEquipo dom = new domEquipo();
		domPiloto domPiloto = new domPiloto();
		List<Equipo> equipos = new ArrayList<>();
		List<Piloto> pilotos = new ArrayList<>();
		try {
			equipos = dom.leerEquiposDesdeXML("formula1.xml");
			pilotos = domPiloto.leerPilotoDesdeXML("formula1.xml");
			logger.info(equipos);
			logger.info(pilotos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EquipoServ servicio = new EquipoServ(equipos);
		
		servicio.rellenaListaPilotos(equipos, pilotos);
		logger.info(equipos);
		
		List<Piloto> pilotos_mayorpuntuacion = servicio.pilotoMayorPuntuacionQue(4, pilotos);
		servicio.escrituraJSON(rutaFichero, pilotos_mayorpuntuacion);
		
		servicio.escrituraXML("equipos.xml", equipos);
	}
}
