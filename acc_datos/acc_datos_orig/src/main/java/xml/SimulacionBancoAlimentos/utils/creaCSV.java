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
	public void CreaFicheroCsv (String ruta,List<Trabajador> trabajadoresVoluntarios,List<CentroLogistico> centros) throws IOException {
		PrintWriter out = null;
		File ruta_real = new File(ruta);
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta_real);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			out.printf(Locale.US, "NombreV,DNIv,FechaNacV,NombreC,IdentificadorC,CiudadC\n");
			for (Trabajador t : trabajadoresVoluntarios) {
				CentroLogistico c = getCentroXTrabajador(t, centros);
				out.printf(Locale.US,"%s,%s,%s,%s,%s,%s%n",
					    t.getNombre(),
					    t.getDni(),
					    t.getFecha_nacimiento(),
					    c.getNombre(),
					    c.getId(),
					    c.getCiudad()
					); 	
			} }
		catch (IOException e) {
					System.out.println("IOException");		} 
		catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally		{
			if (out!=null)
				out.close();
		}	
		}
	
	private CentroLogistico getCentroXTrabajador(Trabajador t, List<CentroLogistico> centros) throws BancoException {
	    CentroLogistico centro = null;
	    String id = t.getId_centrologistico();
	    int i = 0;
	    boolean encontrado = false;

	    while (!encontrado && i < centros.size()) {
	        if (centros.get(i).getId().equals(id)) {
	            centro = centros.get(i);
	            encontrado = true;
	        } else {
	            i++;
	        }
	    }

	    if (centro.equals(null)) {
	        throw new BancoException("No se encuentra un centro con dicho id: " + id);
	    }

	    return centro;
	}

	}


