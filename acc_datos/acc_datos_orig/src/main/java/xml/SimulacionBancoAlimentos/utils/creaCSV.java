package xml.SimulacionBancoAlimentos.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import file.JSON.pokemon.Pokemon;
import xml.SimulacionBancoAlimentos.modelo.CentroLogistico;
import xml.SimulacionBancoAlimentos.modelo.Trabajador;

public class creaCSV {
	public void CreaFicheroCsv (String ruta,List<Trabajador> trabajadoresVoluntarios) throws IOException {
		PrintWriter out = null;
		File ruta_real = new File(ruta);
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta_real);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for (Trabajador t : trabajadoresVoluntarios) {
				out.printf(Locale.US, "NombreV, DNIv,FechaNacV, NombreC, Peso, habilidadPrincipal,evoluciona_a\n" +
					    "%d,%s,%s,%f,%f,%s,%s",
					    p.getId(),
					    p.getNombre(),
					    p.getTipo(),
					    p.getAltura_m(),
					    p.getPeso_kg(),
					    habilidadesConcatenadas,
					    p.getEvoluciona_a()
					); 	
			} }
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	
		}
	
	private CentroLogistico getCentroXTrabajador (Trabajador t) {
		CentroLogistico centro = null;
		
	}
	}


