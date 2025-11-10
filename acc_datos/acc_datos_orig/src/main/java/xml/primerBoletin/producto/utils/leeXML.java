package xml.primerBoletin.producto.utils;

import java.io.File;
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

import xml.primerBoletin.DOM.domPelicula;
import xml.primerBoletin.modelo.Actor;
import xml.primerBoletin.modelo.Pelicula;
import xml.primerBoletin.producto.modelo.Producto;

public class leeXML {
		private static final Logger logger = LogManager.getLogger(domPelicula.class);
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
		private Producto getProductoFromElement(Element elemento) {
			Producto producto = new Producto();
		    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
			int precio = Integer.parseInt(elemento.getElementsByTagName("Precio").item(0).getTextContent().trim());
			int stock = Integer.parseInt(elemento.getElementsByTagName("Stock").item(0).getTextContent().trim());
			int id = Integer.parseInt(elemento.getAttribute("id").trim()); // La etiqueta empleado tiene el atributo identificador
			boolean enVenta = Boolean.parseBoolean(elemento.getAttribute("enVenta"));
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setStock(stock);

			return producto;

		}
		public List<Producto> leerProductosDesdeXML(String rutaFichero) throws Exception {
			List<Producto> productos = new ArrayList<Producto>();
			// 1. Calcula el dom
			Document doc = getDocumentFromXML(rutaFichero);
			// 2. Obtener todos los nodos con etiqueta empleados
			NodeList nodosEmpleados = doc.getElementsByTagName("Producto");
			// 3. Recorro la lista de los nodos empleado
			for (int j = 0; j < nodosEmpleados.getLength(); j++) {
				Node modeloNodo = nodosEmpleados.item(j);
				if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
					Producto e = this.getProductoFromElement((Element) modeloNodo);
					productos.add(e);
				}
			}
			return productos;
		}
}
