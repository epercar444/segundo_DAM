package xml.SimulacionBancoAlimentos.controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.SimulacionBancoAlimentos.modelo.CentroLogistico;
import xml.SimulacionBancoAlimentos.service.BancoAlimentosService;
import xml.SimulacionBancoAlimentos.utils.TipoTrabajador;
import xml.SimulacionBancoAlimentos.utils.leeXML;


public class GestionaBancoAlimentos {
	private static final Logger logger = LogManager.getLogger(GestionaBancoAlimentos.class);
	public static void main(String[] args) {
		leeXML lectorXML = new leeXML();
		List<CentroLogistico> centros = new ArrayList<>();
		try {
			centros = lectorXML.leerCentrosDesdeXML("bancoAlimentos.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BancoAlimentosService service = new BancoAlimentosService(centros);
		
		logger.info(centros);
		
		logger.info(service.trabajadoresPorTipo(TipoTrabajador.ASALARIADO, centros));

	}

}
