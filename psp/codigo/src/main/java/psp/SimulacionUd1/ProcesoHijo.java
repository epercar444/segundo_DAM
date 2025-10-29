package psp.SimulacionUd1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProcesoHijo {public static void main(String[] args) {
	ProcesoHijo ph = new ProcesoHijo();
	String ruta = args[0] + "pedidos.txt";
	String provincia = args[1];
	String rutaDestino = args[0] + args[1] + ".txt";
	try {
		//ph.PedidosPorProvincias(provincia, ruta);
		ph.CreaFicheroPedidos(ruta, provincia, rutaDestino);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public List<String> PedidosPorProvincias(String provincia,String ruta) throws FileNotFoundException {
		int contador = 0;
		int contadorPedido = 0;
		List<String> pedidosPorprovincia = new ArrayList<>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			in.nextLine();
			while (in.hasNext()) { 
				String linea = in.nextLine();
				contadorPedido += 1;
				String[] linea_split = linea.split("#");
				//System.out.println(Arrays.toString(linea_split));
				String linea_espacio = linea_split[5].trim();
				if (linea_espacio.equals(provincia)) {
						pedidosPorprovincia.add(linea);
						contador += 1;
					}
				}
		} finally {
			if (in != null) {
				in.close();
			}
			System.out.println(provincia+":"+contador);
			System.out.println("Total pedidos:"+contadorPedido);
		}
		return pedidosPorprovincia;
	}
	public void CreaFicheroPedidos (String rutaFicheroABuscar,String provincia,String ruta) throws IOException {
		List<String> pedidosPorprovincia = PedidosPorProvincias(provincia,rutaFicheroABuscar);
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for (String f : pedidosPorprovincia) {
				String[] linea_split = f.split("#");
				out.printf("Artículo: %s, Unidades: %s, Importe: %s, Referencia: %s, Dirección: %s, Provincia: %s, Fecha: %s%n",
					    linea_split[0], linea_split[1], linea_split[2],
					    linea_split[3], linea_split[4], linea_split[5], linea_split[6]
					);
			}
			}		
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}
	
}

