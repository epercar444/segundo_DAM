package xml.primerBoletin.producto.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import xml.primerBoletin.producto.modelo.Producto;

public class escribeJSON {
	public void escrituraJson (String ruta,List<Producto> productos) {
		// Convertir el objeto a JSON
			 Gson gson = new Gson();
			 String json = gson.toJson(productos);
			 FileWriter fichero = null;
			 try {
				fichero = new FileWriter(ruta);
				fichero.write(json);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fichero != null) {
					try {
						fichero.close();
					} catch (IOException e) {
						System.out.println("Error al escribir piloto");
					}			}		}	   }
	}

