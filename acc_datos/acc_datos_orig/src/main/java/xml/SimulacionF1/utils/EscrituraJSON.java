package xml.SimulacionF1.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import file.JSON.pokemon.Pokemon;
import xml.SimulacionF1.modelo.Piloto;

public class EscrituraJSON {
	public void escrituraJson (String ruta,List<Piloto> pilotos) {
		// Convertir el objeto a JSON
			 Gson gson = new Gson();
			 String json = gson.toJson(pilotos);
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

