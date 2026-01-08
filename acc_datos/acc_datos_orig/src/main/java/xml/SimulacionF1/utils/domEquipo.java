package xml.SimulacionF1.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.SimulacionF1.modelo.Equipo;
import xml.SimulacionF1.modelo.Piloto;
import xml.primerBoletin.modelo.Actor;
import xml.primerBoletin.modelo.Pelicula;

public class domEquipo {
	private static final Logger logger = LogManager.getLogger(domEquipo.class);
	private Document getDocumentFromXML(String nombrefichero) {
		File file = new File("src/main/resources/"+ nombrefichero);
		Document documento = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			documento = dBuilder.parse(file);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return documento;
	} 
	public Equipo getEquipoFromElement(Element elemento)
	{
			Equipo e = new Equipo();
			String nombre = elemento.getElementsByTagName("nombreEquipo").item(0).getTextContent();
			int puntos = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent());
			List<Piloto> pilotos = null;
			int id = Integer.parseInt(elemento.getAttribute("identificadorEquipo"));		
		    e.setNombre(nombre);
		    e.setPilotos(pilotos);
		    e.setPuntos(puntos);
		    e.setId(id);
			return e;
		}
	public List<Equipo> leerEquiposDesdeXML(String rutaFichero) throws Exception {
		List<Equipo> equipos = new ArrayList<Equipo>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosEmpleados = doc.getElementsByTagName("equipo");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosEmpleados.getLength(); j++) {
			Node modeloNodo = nodosEmpleados.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Equipo e = this.getEquipoFromElement((Element) modeloNodo);
				equipos.add(e);
			}
		}
		return equipos;
	}

}
