package psp.PruebaPractica1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcesoHijo {
	public static void main(String[] args) {
		String rutaFicheroABuscar = args[0] + "lecturas.txt";
		String ruta_Escritura = args[0] + args[1] + ".txt";
		String tipo_sensor = args[1];
		ProcesoHijo ph = new ProcesoHijo();
		try {
			System.out.println(ph.GuardarLecturaSensor(rutaFicheroABuscar, tipo_sensor));
			ph.GeneraSensorFichero(rutaFicheroABuscar, ruta_Escritura, tipo_sensor);
			ph.LecturaResumenSensor(rutaFicheroABuscar, tipo_sensor);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<String> GuardarLecturaSensor (String ruta,String tipo_sensor) throws FileNotFoundException {
		List<String> lectura_sensor = new ArrayList<>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			while (in.hasNext()) { 
				String linea = in.nextLine();
				String [] linea_split = linea.split(";");
				if (linea_split[0].equalsIgnoreCase(tipo_sensor)) {
						lectura_sensor.add(linea);
					}
				}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return lectura_sensor;
	}
	
	public void GeneraSensorFichero (String rutaFicheroABuscar,String ruta,String tipo_sensor) throws IOException {
		List<String> lectura_temperatura = GuardarLecturaSensor(rutaFicheroABuscar,tipo_sensor);
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(ruta);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for (String s : lectura_temperatura) {
				out.printf("%s %n" , s);
			}
			}		
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}
	
	public void LecturaResumenSensor (String ruta,String tipo_sensor) {
		List<String> lista_lectura = new ArrayList<>();
		float media = 0;
		try {
			lista_lectura = GuardarLecturaSensor(ruta, tipo_sensor);
			media = CalculaMediaTipoSensor(ruta, tipo_sensor);
			System.out.println(tipo_sensor+": NºRegistros: "+lista_lectura.size()+" ,Media: "+media);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public float CalculaMediaTipoSensor (String ruta, String tipo_sensor) {
		float media_principal = 0;
		List<String> lista_lectura = new ArrayList<>();
		try {
			lista_lectura = GuardarLecturaSensor(ruta, tipo_sensor);
			for (String s : lista_lectura) {
				String[] s_split = s.split(";");
				float media = Float.parseFloat(s_split[1]);
				media_principal += media;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float media_final = media_principal / lista_lectura.size();
		return media_final;
	}
}
