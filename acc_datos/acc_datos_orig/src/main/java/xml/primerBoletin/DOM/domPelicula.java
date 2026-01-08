package xml.primerBoletin.DOM;

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

import xml.primerBoletin.modelo.Actor;
import xml.primerBoletin.modelo.Pelicula;
import xml.primeraspruebas.modelo.Empleado;
public class domPelicula {
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
	public  Pelicula getPeliculaFromElement(Element elemento)
	{
			Pelicula p = new Pelicula();
			String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
			int anyo = Integer.parseInt(elemento.getElementsByTagName("Fecha").item(0).getTextContent());
			String director = elemento.getElementsByTagName("Director").item(0).getTextContent();
		    List<Actor> actoresList = new ArrayList<>();
		    NodeList actoresNodos = ((Element) elemento.getElementsByTagName("Actores").item(0)).getElementsByTagName("Actor");
		    for (int i = 0; i < actoresNodos.getLength(); i++) {
		        Actor a = new Actor();
		        a.setActor(actoresNodos.item(i).getTextContent());
		        actoresList.add(a);		    
		        }			
		    p.setAnyo(anyo);
			p.setDirector(director);
			p.setTitulo(titulo);
		    p.setActores(actoresList);
			return p;
		}
	public List<Pelicula> leerPeliculasDesdeXML(String rutaFichero) throws Exception {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosEmpleados = doc.getElementsByTagName("Pelicula");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosEmpleados.getLength(); j++) {
			Node modeloNodo = nodosEmpleados.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Pelicula e = this.getPeliculaFromElement((Element) modeloNodo);
				peliculas.add(e);
			}
		}
		return peliculas;
	}

}

