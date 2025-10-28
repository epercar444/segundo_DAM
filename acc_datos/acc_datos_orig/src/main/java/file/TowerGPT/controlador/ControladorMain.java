package file.TowerGPT.controlador;

import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import file.TowerGPT.modelo.InteraccionAgente;
import file.TowerGPT.modelo.TipoAgenteEnum.TipoAgente;
import file.TowerGPT.repositorio.InteraccionAgenteRepo;
import file.TowerGPT.servicio.InteraccionAgenteServ;

public class ControladorMain {
	private static final Logger logger = LogManager.getLogger(ControladorMain.class);
	public static void main(String[] args) {
		InteraccionAgenteRepo repo = new InteraccionAgenteRepo();
		Set<InteraccionAgente> interacciones = repo.getInteracciones();
		InteraccionAgenteServ serv = new InteraccionAgenteServ();
		String rutaFicheroTexto = "src/main/resources/TowerGPT.txt";
		String rutaFicheroCSV = "src/main/resources/TowerGPT.csv";
		String rutaFicheroJson = "src/main/resources/TowerGPT.json";
		InteraccionAgente agenteHumano1 = new InteraccionAgente(85, TipoAgente.HUMANO, "¿Cuál es la capital de Francia?", "París", 4.5f, 1.3f);
		InteraccionAgente agenteHumano2 = new InteraccionAgente(90, TipoAgente.HUMANO, "Resuelve 5+7", "12", 4.8f, 0.9f);
		InteraccionAgente agenteHumano3 = new InteraccionAgente(75, TipoAgente.HUMANO, "Traduce al inglés: 'Hola mundo'", "Hello world", 4.7f, 1.1f);
		InteraccionAgente agenteIA1 = new InteraccionAgente(95, TipoAgente.IA, "Genera un poema corto", "Rosa roja en el jardín", 5.0f, 0.7f);
		InteraccionAgente agenteIA2 = new InteraccionAgente(80, TipoAgente.IA, "Resume este texto", "Resumen breve del texto", 4.2f, 1.0f);
		serv.anadirInterracion(agenteHumano1);
		serv.anadirInterracion(agenteHumano2);
		serv.anadirInterracion(agenteHumano3);
		serv.anadirInterracion(agenteIA1);
		serv.anadirInterracion(agenteIA2);
		logger.info("Lista interacciones: "+serv.getClase_repo().getInteracciones());
		serv.grabarResumenEstadistica(rutaFicheroTexto);
		logger.info("Interacción con mayor valoración: "+serv.obtenerInteraccionConMejorValoracion());
		InteraccionAgente agenteIAval = new InteraccionAgente(66, TipoAgente.IA, "Resume este texto", "Resumen breve del texto", 3.3f, 1.4f);
		serv.actualizaInteraccion(agenteIAval,5);
		logger.info("INteracciones actualizadas: "+serv.getClase_repo().getInteracciones());
		serv.grabarFicheroCsv(rutaFicheroCSV, interacciones);
		logger.info("Leyendo desde el archivo Json: " +serv.cargarRegistrosDesdeJSON(rutaFicheroJson));
		logger.info("Interacciones con porcentaje mayor al 70%: "+serv.obtenerInteraccionesAciertoMayorQueOrdenadas(70.0f));
		serv.agruparInteraccionesPorTipo();
	}
}
