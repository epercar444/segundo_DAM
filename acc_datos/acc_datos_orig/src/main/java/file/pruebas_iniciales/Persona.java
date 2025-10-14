package file.pruebas_iniciales;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Persona {
	private String nombre;
	private List<Double> notas;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	public Persona(String nombre, List<Double> lista) {
		super();
		this.nombre = nombre;
		this.notas = lista;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", notas=" + notas + "]";
	}
	
	Persona muestraContenidoFich(String rutaYNombre) throws FileNotFoundException {
		Persona p = new Persona(nombre, notas);
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			//Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { //Lectura palabra a palabra
				// Aquí se hará la lectura in.next()
				p = new Persona(nombre, notas);
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return p;
	}
	
	
	
	
}
