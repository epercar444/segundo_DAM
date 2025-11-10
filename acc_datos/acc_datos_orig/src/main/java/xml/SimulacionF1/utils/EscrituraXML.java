package xml.SimulacionF1.utils;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import xml.SimulacionF1.modelo.Equipo;
import xml.SimulacionF1.modelo.Piloto;
import xml.primerBoletin.escituraXML.Producto;
import xml.primerBoletin.escituraXML.ejemploEscritura;

public class EscrituraXML {
	private static final String rutaResources = "src/main/resources/";
	private static final Logger logger = LogManager.getLogger(ejemploEscritura.class);
	
	private void agregaEquipoADocumento(Document documento,Element padre, Equipo p) {
		// Para cada una de los atributos de persona, creo un elemento hijo
		Element nombre = this.creaElemento("nombreEquipo", p.getNombre(), padre, documento);
		Element puntos = this.creaElemento("puntos", Integer.toString(p.getPuntos()), padre, documento);
	    Element pilotosElement = documento.createElement("pilotos");
	    for (Piloto piloto : p.getPilotos()) {
	        Element pilotoElement = documento.createElement("piloto");
	        Element nombrePiloto = this.creaElemento("nombre", piloto.getNombre(), pilotoElement, documento);
	        Element pais = this.creaElemento("pais", piloto.getPais(), pilotoElement, documento);
	        Element puntosPiloto = this.creaElemento("puntos", Integer.toString(piloto.getPuntos()), pilotoElement, documento);
	        Element idEquipo = this.creaElemento("idEquipo", Integer.toString(piloto.getIdEquipo()), pilotoElement, documento);
	        pilotoElement.setAttribute("idPiloto",Integer.toString(piloto.getId()));
	        pilotosElement.appendChild(pilotoElement);
	    }
		// El identificador lo vamos a crear como un atributo de la etiqueta empleado
        padre.appendChild(pilotosElement);
		padre.setAttribute("idEquipo", Integer.toString(p.getId()));
	}

	private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		Text texto = documento.createTextNode(valorElemento);
		padre.appendChild(elemento);// Se lo asigno a su padre como Hijo
		elemento.appendChild(texto);// Cargo el elemento con el valor
		return elemento;
	}

	private Document construyoObjetoDocumento(String nombreRaiz) throws ParserConfigurationException {
		Document documento = null;
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		DOMImplementation implementacion = builder.getDOMImplementation();
		documento = implementacion.createDocument(null, nombreRaiz, null);
		// Primer parámetro uri: si null no está validado por ninguna ruta
		// segundo parámetro: nombre fichero
		// tercer parámetro: document type Por defecto null
		return documento;
	}

	private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		// clases necesarias finalizar la creación del archivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(this.rutaResources + nombreFichero));
		transformer.transform(source, resultado);
	}

	public void escribeProductosEnXML(String nombreFichero, List<Equipo> equipos) {
		try {
			Document documento = this.construyoObjetoDocumento("productos.xml");
			for(Equipo e : equipos)
			{
				Element elemento = this.creaElemento("Equipo", null, documento.getDocumentElement(), documento);
				agregaEquipoADocumento(documento, elemento, e);
			}
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}

}
