package xml.SimulacionBancoAlimentos.utils;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.SimulacionBancoAlimentos.modelo.CentroLogistico;
import xml.SimulacionBancoAlimentos.modelo.Trabajador;
import xml.SimulacionF1.modelo.Equipo;
import xml.SimulacionF1.modelo.Piloto;
import xml.SimulacionF1.utils.domEquipo;

public class leeXML {
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
	public CentroLogistico getCentroLogisticoFromElement(Element elemento) {
	    CentroLogistico centro = new CentroLogistico();

	    // Datos básicos del centro
	    String id = elemento.getElementsByTagName("ID").item(0).getTextContent();
	    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
	    String ciudad = elemento.getElementsByTagName("Ciudad").item(0).getTextContent();
	    int comedoresAbastecidos = Integer.parseInt(elemento.getElementsByTagName("ComedoresAbastecidos").item(0).getTextContent());

	    centro.setId(id);
	    centro.setNombre(nombre);
	    centro.setCiudad(ciudad);
	    centro.setNumComedores(comedoresAbastecidos);
	    List<Trabajador> trabajadores =addTrabajadoresToCL(elemento, id);
	    centro.setTrabajadores(trabajadores);
	    return centro;
	}
	private List<Trabajador> addTrabajadoresToCL (Element elemento,String id){
	    List<Trabajador> trabajadores = new ArrayList<>();
	    NodeList listaTrabajadores = elemento.getElementsByTagName("Trabajador");
	    for (int i = 0; i < listaTrabajadores.getLength(); i++) {
	        Element t = (Element) listaTrabajadores.item(i);
	        Trabajador trabajador = new Trabajador();
	        trabajador.setNombre(t.getElementsByTagName("Nombre").item(0).getTextContent());
	        trabajador.setDni(t.getElementsByTagName("DNI").item(0).getTextContent());
	        trabajador.setFecha_nacimiento(LocalDate.parse(t.getElementsByTagName("FechaNacimiento").item(0).getTextContent()));;
	        String tipoStr = t.getElementsByTagName("Tipo").item(0).getTextContent();
	        trabajador.setTipo(TipoTrabajador.valueOf(tipoStr.toUpperCase()));
	        trabajador.setId_centrologistico(id);
	        trabajadores.add(trabajador);
	    }
	    return trabajadores;
	}
	public List<CentroLogistico> leerCentrosDesdeXML(String rutaFichero) throws Exception {
		List<CentroLogistico> centros= new ArrayList<CentroLogistico>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosEmpleados = doc.getElementsByTagName("CentroLogistico");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosEmpleados.getLength(); j++) {
			Node modeloNodo = nodosEmpleados.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				CentroLogistico e = this.getCentroLogisticoFromElement((Element) modeloNodo);
				centros.add(e);
			}
		}
		return centros;
	}

}
