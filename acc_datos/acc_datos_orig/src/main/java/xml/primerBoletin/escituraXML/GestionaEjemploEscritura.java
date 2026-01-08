package xml.primerBoletin.escituraXML;

import java.util.ArrayList;
import java.util.List;

public class GestionaEjemploEscritura {
	public static void main(String[] args) {
		ejemploEscritura escritura = new ejemploEscritura();
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, 50, "Teclado Mecánico", 59.99f, true));
        productos.add(new Producto(2, 20, "Ratón Inalámbrico", 29.50f, true));
        productos.add(new Producto(3, 0, "Monitor 24 pulgadas", 149.99f, false));
        productos.add(new Producto(4, 10, "Auriculares Bluetooth", 79.90f, true));
        productos.add(new Producto(5, 5, "Webcam Full HD", 45.00f, true));
        
        escritura.escribeProductosEnXML("productos1.xml", productos);
	}
}
