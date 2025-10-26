package file.TowerGPT.servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import file.TowerGPT.Exceptions.NotFoundException;
import file.TowerGPT.Exceptions.SetValidacionException;
import file.TowerGPT.modelo.InteraccionAgente;
import file.TowerGPT.modelo.TipoAgenteEnum.TipoAgente;
import file.TowerGPT.repositorio.InteraccionAgenteRepo;

public class InteraccionAgenteServ {
	private static final Logger logger = LogManager.getLogger(InteraccionAgenteServ.class);
	InteraccionAgenteRepo clase_repo;
	
	public InteraccionAgenteServ() {
		super();
		this.clase_repo =new InteraccionAgenteRepo();
	}
	

	public InteraccionAgenteRepo getClase_repo() {
		return clase_repo;
	}


	public void setClase_repo(InteraccionAgenteRepo clase_repo) {
		this.clase_repo = clase_repo;
	}


	//métodos Repositorio
	public void anadirInterracion (InteraccionAgente interaccion) {
			clase_repo.anadirInteraccion(interaccion);
	}
	
	public void eliminnarInteraccion (int id) {
		try {
			clase_repo.eliminarInteraccion(id);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void leeInteraccion (int id) {
		try {
			clase_repo.leeInteraccion(id);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizaInteraccion (InteraccionAgente a,int id) {
		try {
			clase_repo.actualizarInteraccion(a,id);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int incrementaNumValoraciones () {
		int NumValoraciones = clase_repo.incrementaNumValoraciones();
		return NumValoraciones;
	}
	
	public int actualizaPorcentajeAcierto () {
		int mediaPorcentajeAcierto = clase_repo.actualizaPorcentaje();
		return mediaPorcentajeAcierto;
	}
	
	//lectura y escritura CSV y Json
	public Set<InteraccionAgente> cargarRegistrosDesdeJSON(String ruta) {
	    Set<InteraccionAgente> interacciones = new HashSet<>();
	    Gson gson = new Gson();

	    try (FileReader reader = new FileReader(new File(ruta))) {
	        InteraccionAgente[] array = gson.fromJson(reader, InteraccionAgente[].class);
	        interacciones = new HashSet<>(Arrays.asList(array));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    return interacciones;
	}
	
	public void grabarFicheroCsv(String ruta, Set<InteraccionAgente> interacciones) {
	    interacciones = clase_repo.getInteracciones();
		PrintWriter out = null;
	    File ruta_real = new File(ruta);

	    try {
	        FileWriter ficheroSalida = new FileWriter(ruta_real);
	        out = new PrintWriter(ficheroSalida);

	        out.println("Id,TipoAgente,Peticion,Respuesta,Valoracion,Porcentaje_Acierto");

	        for (InteraccionAgente a : interacciones) {
	        	out.printf(Locale.US, "%d,%s,%s,%s,%f,%d%n",
	        		    a.getId(),
	        		    a.getTipoAgente(),
	        		    a.getPeticion(),
	        		    a.getRespuesta(),
	        		    a.getValoracion(),
	        		    a.getPorcentaje_Acierto()
	        		);
	        }

	    } catch (IOException e) {
	        System.out.println("IOException");
	    } finally {
	        if (out != null)
	            out.close();
	    }
	}

	
	//otros métodos añadidos a servicio
	public InteraccionAgente obtenerInteraccionConMejorValoracion () {
		Set<InteraccionAgente> interacciones = clase_repo.getInteracciones();
		List<InteraccionAgente> listaInteracciones = new ArrayList<>(interacciones);
		InteraccionAgente mejor = listaInteracciones.get(0);
		  for (int i = 1; i < listaInteracciones.size(); i++) { 
		        InteraccionAgente actual = listaInteracciones.get(i);
		        if (actual.getValoracion() > mejor.getValoracion()) {
		            mejor = actual;
		        }
		    }
		    return mejor;
		}
	public float calcularTiempoMedioPorTipo (TipoAgente a) { //me invento los datos porque no me los aporta el enunciado
		float tiempoMedio = 0;
		if (a.equals(TipoAgente.HUMANO)) {
			tiempoMedio = 3.3f;
		}
		else {
			tiempoMedio = 2.5f;
		}
		return tiempoMedio;
	}
	
	public float calculaPorcentajAciertoMedioPorTipo(TipoAgente p) {
	    float suma = 0;
	    int contador = 0;
	    for (InteraccionAgente f : clase_repo.getInteracciones()) {
	        if (f.getTipoAgente() == p) {
	            suma += f.getPorcentaje_Acierto();
	            contador++;
	        }
	    }
	    float porcentaje_real = suma / contador;
	    if (contador == 0) {
	        porcentaje_real = 0;
	    }
	    return porcentaje_real;
	}

	
	public Set<InteraccionAgente> obtenerInteraccionesAciertoMayorQueOrdenadas (float porcentajeComparado) {
		Set<InteraccionAgente> interaccionesOrdenadas = new TreeSet<>();

		for (InteraccionAgente p : clase_repo.getInteracciones()) {
		    if (p.getPorcentaje_Acierto() > porcentajeComparado) {
		        interaccionesOrdenadas.add(p);
		    }
		}
		return interaccionesOrdenadas;
	}
	public void agruparInteraccionesPorTipo () {
		List<InteraccionAgente> tipo_humano = new ArrayList<>();
		List<InteraccionAgente> tipo_ia = new ArrayList<>();
		for (InteraccionAgente a : clase_repo.getInteracciones()) {
			if (a.getTipoAgente().equals(TipoAgente.HUMANO)) {
				tipo_humano.add(a);
			}
			else {
				tipo_ia.add(a);
			}
		}
		logger.info("Las interacciones con agentes Humanos son: "+tipo_humano);
		logger.info("Las interacciones con agentes IAs son: "+tipo_ia);
	}
	public void grabarResumenEstadistica (String ruta) {
			PrintWriter out = null;
			try {
				FileWriter ficheroSalida;
					ficheroSalida = new FileWriter(ruta);
				// abre el fichero de texto
				out = new PrintWriter(ficheroSalida);
				String mayorTiempo = mayorTiempoMedioEstadistica();
				float tiempoMedio = tiempoMedioEstadistica();
				int numeroTotalInteracciones = NumTotalInteracciones();
				int numeroInteraccionesHum = NumTotalInteraccionesPorTipo(TipoAgente.HUMANO);
				int numeroInteraccionesIA = NumTotalInteraccionesPorTipo(TipoAgente.IA);
				float valoracionMediaHum = valoracionMediaPorTipo(TipoAgente.HUMANO);
				float valoracionMediaIA = valoracionMediaPorTipo(TipoAgente.IA);
				float porcentajeHum = calculaPorcentajAciertoMedioPorTipo(TipoAgente.HUMANO);
				float porcentajeIA = calculaPorcentajAciertoMedioPorTipo(TipoAgente.IA);
				// escribe el listado persona a persona
				out.printf(
					    "RESUMEN DE INTERACCIONES :\n" +
					    "---------------------------------------\n" +
					    "Se han efectuado un total de %d interacciones\n" +
					    "Las interacciones que han tomado más tiempo han sido las efectuadas por %s con un tiempo medio de %.2f segundos\n" +
					    "De todas las interacciones:\n" +
					    "- %d han sido efectuadas por Humanos con una valoración media de %.2f y una tasa de aciertos del %.2f%%\n" +
					    "- %d han sido efectuadas por IAs con una valoración media de %.2f y una tasa de acierto del %.2f%%\n",
					    numeroTotalInteracciones,
					    mayorTiempo,
					    tiempoMedio,
					    numeroInteraccionesHum,
					    valoracionMediaHum,
					    porcentajeHum,
					    numeroInteraccionesIA,
					    valoracionMediaIA,
					    porcentajeIA
					);
			}
			catch (IOException e) {
						System.out.println("IOException");		}
			finally		{
				if (out!=null)
					out.close();
			}	}
	//métodos adicionales para que el registro saque todos los datos		
	public String mayorTiempoMedioEstadistica () {
		String tipo = null;
		float tiempoMediaHumano = calcularTiempoMedioPorTipo(TipoAgente.HUMANO);
		float tiempoMediaIA = calcularTiempoMedioPorTipo(TipoAgente.IA);
		if (tiempoMediaHumano > tiempoMediaIA) {
			tipo = "Humanos";
		}
		else {
			tipo = "IA";
		}
		return tipo;
	}
	
	public float tiempoMedioEstadistica () {
	float media = 0;
	float tiempoMediaHumano = calcularTiempoMedioPorTipo(TipoAgente.HUMANO);
	float tiempoMediaIA = calcularTiempoMedioPorTipo(TipoAgente.IA);
	if (tiempoMediaHumano > tiempoMediaIA) {
		media = tiempoMediaHumano;
	}
	else {
		media = tiempoMediaIA;
	}
	return media;
	}
	
	public int NumTotalInteracciones () {
		int contador = 0;
		for (InteraccionAgente f : clase_repo.getInteracciones()) {
			contador += 1;
		}
		return contador;
	}
	public int NumTotalInteraccionesPorTipo(TipoAgente p) {
	    int contador = 0;
	    for (InteraccionAgente f : clase_repo.getInteracciones()) {
	        if (f != null && p != null && p.equals(f.getTipoAgente())) {
	            contador++;
	        }
	    }
	    return contador;
	}

	public float valoracionMediaPorTipo(TipoAgente p) {
	    float valoracionTotal = 0;
	    int contador = 0;
	    for (InteraccionAgente f : clase_repo.getInteracciones()) {
	        if (f.getTipoAgente() == p) {
	            valoracionTotal += f.getValoracion();
	            contador++;
	        }
	    }
	    float valoracion_real = valoracionTotal / contador;
	    if (contador == 0) {
	        valoracion_real = 0;
	    }
	    return valoracion_real;
	}

}
	

	

