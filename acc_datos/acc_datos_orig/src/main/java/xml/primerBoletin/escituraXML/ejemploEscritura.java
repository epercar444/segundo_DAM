package xml.primerBoletin.escituraXML;

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

public class ejemploEscritura {
	private static final String rutaResources = "src/main/resources/";
	private static final Logger logger = LogManager.getLogger(ejemploEscritura.class);
	
	private void agregaEmpleadoADocumento(Document documento,Element padre,  Producto p) {
		// Para cada una de los atributos de persona, creo un elemento hijo
		Element nombre = this.creaElemento("nombre", p.getNombre(), padre, documento);
		Element precio = this.creaElemento("precio", Float.toString(p.getPrecio()), padre, documento);
		Element stock = this.creaElemento("stock", Integer.toString(p.getStock()), padre, documento);
		// El identificador lo vamos a crear como un atributo de la etiqueta empleado
		padre.setAttribute("id", Integer.toString(p.getId()));
		padre.setAttribute("aLaVenta", Boolean.toString(p.getaLaVenta()));
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

	public void escribeProductosEnXML(String nombreFichero, List<Producto> productos) {
		try {
			Document documento = this.construyoObjetoDocumento("productos.xml");
			for(Producto e : productos)
			{
				Element elemento = this.creaElemento("Producto", null, documento.getDocumentElement(), documento);
				agregaEmpleadoADocumento(documento, elemento, e);
			}
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}

}
