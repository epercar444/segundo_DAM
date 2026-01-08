package xml.primeraspruebas.repositorio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import xml.primeraspruebas.modelo.Empleado;

public class domEmpleado {
	private static final Logger logger = LogManager.getLogger(domEmpleado.class);
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
	public  Empleado getEmpleadoFromElement(Element elemento)
	{
			Empleado e = new Empleado();
			String nombre = elemento.getElementsByTagName("nombreApellido").item(0).getTextContent();
			int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
			String empresa = elemento.getElementsByTagName("empresa").item(0).getTextContent();
			String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			e.setEdad(edad);
			e.setNombreApellido(nombre);
			e.setIdentificador(id);
			e.setEmpresa(empresa);
			return e;
		}
	public Empleado leerEmpleadoDesdeXML(String rutaFichero) throws Exception {
	       Document doc = getDocumentFromXML(rutaFichero);
	       // Obtener el elemento raíz (el único <empleado>)
	       Element elementoEmpleado = doc.getDocumentElement();
	       // Usar tu método
	       return getEmpleadoFromElement(elementoEmpleado);
	   }

}


