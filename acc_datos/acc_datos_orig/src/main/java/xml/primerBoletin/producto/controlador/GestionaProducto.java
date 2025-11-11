package xml.primerBoletin.producto.controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.primerBoletin.producto.modelo.Producto;
import xml.primerBoletin.producto.service.ProductoServ;

public class GestionaProducto {
	private static final String rutaFicheroJSON = "src/main/resources/productos.json";
	private static final Logger logger = LogManager.getLogger(GestionaProducto.class);
	public static void main(String[] args) {
		ProductoServ servicio = new ProductoServ();
		
		List<Producto> productos = servicio.leeProductosFromXMl("productos.xml");
		logger.info(productos);
		
		logger.info(servicio.buscarInferiorA(5, productos));
		
		servicio.retirarVenta(productos, 5);
		logger.info(productos);
		
		List<Producto> lista_inferiores = servicio.buscarInferiorA(5, productos);
		servicio.escribeJSON(rutaFicheroJSON, lista_inferiores);
		
		servicio.generaXML("productosNoALaVenta.xml", lista_inferiores);

	}

}
