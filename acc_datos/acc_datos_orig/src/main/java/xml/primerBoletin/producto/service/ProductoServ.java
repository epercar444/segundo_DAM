package xml.primerBoletin.producto.service;

import java.util.ArrayList;
import java.util.List;

import xml.primerBoletin.producto.modelo.Producto;
import xml.primerBoletin.producto.utils.escribeJSON;
import xml.primerBoletin.producto.utils.generaXML;
import xml.primerBoletin.producto.utils.leeXML;

public class ProductoServ {
	private leeXML lectorXML;
	private escribeJSON escritorJSON;
	private generaXML escritorXML;

	public ProductoServ() {
		super();
		this.lectorXML = new leeXML();
		this.escritorJSON = new escribeJSON();
		this.escritorXML = new generaXML();
	}
	
	public List<Producto> leeProductosFromXMl(String rutaFichero) {
		List<Producto> productos = new ArrayList<>();
		try {
			productos = lectorXML.leerProductosDesdeXML(rutaFichero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}
	
	public List<Producto> buscarInferiorA (int stock,List<Producto> productos) {
		List<Producto> productos_inferiores = new ArrayList<>();
		for (Producto p : productos) {
			if (p.getStock() < stock) {
				productos_inferiores.add(p);
			}
		}
		return productos_inferiores;
	}
	
	public void retirarVenta (List<Producto> productos,int stock) {
		List<Producto> productos_inferiores = buscarInferiorA(stock, productos);
		for (Producto p : productos_inferiores) {
			p.setaLaVenta(false);
		}
	}
	
	public void escribeJSON (String ruta,List<Producto> productos) {
		escritorJSON.escrituraJson(ruta, productos);
	}
	
	public void generaXML (String nombreFichero, List<Producto> productos) {
		escritorXML.escribeProductosEnXML(nombreFichero, productos);
	}
}
