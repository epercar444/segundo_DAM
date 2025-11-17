package psp.tema2.boletin2;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class MetodoLeerCaracteres implements Runnable{
	private File fichero;
	private int numCaracteres;
	public MetodoLeerCaracteres() {
		super();
	}
	public MetodoLeerCaracteres(File fichero, int numCaracteres) {
		super();
		this.fichero = fichero;
		this.numCaracteres = numCaracteres;
	}
	public File getFichero() {
		return fichero;
	}
	public void setFichero(File fichero) {
		this.fichero = fichero;
	}
	public int getNumCaracteres() {
		return numCaracteres;
	}
	public void setNumCaracteres(int numCaracteres) {
		this.numCaracteres = numCaracteres;
	}
	public void leerCaracteres ()  {
		File fichero = new File("src/main/resouces");
		fichero.mkdir();
		List<String> ficheros = new ArrayList<>();
		for (File f : ) {
			new Thread()
			
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
