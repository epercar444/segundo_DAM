package file.segundo_boletin.Ejercicio1SinMVC;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import file.primer_boletin.controlador.PrimerBoletin_main;


public class DiffFolder {
	private static final Logger logger = LogManager.getLogger(PrimerBoletin_main.class);
	private File ruta1;
	private File ruta2;
	public DiffFolder(File ruta1, File ruta2) {
		super();
		this.ruta1 = ruta1;
		this.ruta2 = ruta2;
	}
	public File getRuta1() {
		return ruta1;
	}
	public void setRuta1(File ruta1) {
		this.ruta1 = ruta1;
	}
	public File getRuta2() {
		return ruta2;
	}
	public void setRuta2(File ruta2) {
		this.ruta2 = ruta2;
	}
	
	
	
	public boolean setFolders (File folder1, File folder2) throws GestionFicherosException {
		boolean sonDirectorios = true;
		if (folder1.exists() && folder2.exists()) {
			boolean esDirectorio1 = folder1.isDirectory();
			boolean esDirectorio2 = folder2.isDirectory();
			if (!esDirectorio1 || !esDirectorio2) {
				sonDirectorios = false;
				throw new GestionFicherosException ("Las rutas dadas no son directorios");
			}
		}
		return sonDirectorios;
	}
	
	public Set<File> getNumFicheroPorDirectorio (File folder1, File folder2) throws GestionFicherosException {
		int contador = 0;
		int contador1 = 0;
		boolean sonDirectorios = setFolders(folder1, folder2); 
		Set <File> orden_ficheros = new HashSet<>();
		if (sonDirectorios)
			for (File f : folder1.listFiles()) {
					contador ++;
			}
			for (File w : folder2.listFiles()) {
				contador1++;
			}
			if (contador >= contador1) {
				orden_ficheros.add(folder1);
				orden_ficheros.add(folder2);
			}
			else {
				orden_ficheros.add(folder2);
				orden_ficheros.add(folder1);
			}
			
			logger.debug(contador);
			logger.debug(contador1);
		return orden_ficheros;
	}
	
	public Set<ResultadoComparacion> compare(File folder1, File folder2) throws GestionFicherosException {
		Set<File> ficheros_orden = getNumFicheroPorDirectorio(folder1, folder2);
		return null;
		
	}
}

