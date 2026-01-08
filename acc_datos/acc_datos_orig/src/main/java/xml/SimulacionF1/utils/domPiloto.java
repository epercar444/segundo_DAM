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

public class domPiloto {
	private static final Logger logger = LogManager.getLogger(domPiloto.class);
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
	public Piloto getPilotoFromElement(Element elemento)
	{
			Piloto p = new Piloto();
			String nombre = elemento.getElementsByTagName("nombrePiloto").item(0).getTextContent();
			int puntos = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent());
			int idEquipo = Integer.parseInt(elemento.getElementsByTagName("identificadorEquipo").item(0).getTextContent());
			String pais = elemento.getElementsByTagName("pais").item(0).getTextContent();
			int id = Integer.parseInt(elemento.getAttribute("identificadorPiloto"));		
		    p.setId(id);
		    p.setIdEquipo(idEquipo);
		    p.setNombre(nombre);
		    p.setPais(pais);
		    p.setPuntos(puntos);
			return p;
		}
	public List<Piloto> leerPilotoDesdeXML(String rutaFichero) throws Exception {
		List<Piloto> pilotos = new ArrayList<Piloto>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosEmpleados = doc.getElementsByTagName("piloto");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosEmpleados.getLength(); j++) {
			Node modeloNodo = nodosEmpleados.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Piloto e = this.getPilotoFromElement((Element) modeloNodo);
				pilotos.add(e);
			}
		}
		return pilotos;
	}
}
