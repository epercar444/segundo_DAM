package file.segundo_boletin.Ejercicio1SinMVC;

import java.io.File;
import java.time.LocalDate;
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
		File [] ficheros_folder1 = folder1.listFiles();
		File [] ficheros_folder2 = folder2.listFiles();
		boolean sonDirectorios = setFolders(folder1, folder2); 
		Set <File> orden_ficheros = new HashSet<>();
		if (sonDirectorios) {
			if (ficheros_folder1.length >= ficheros_folder2.length) {
				orden_ficheros.add(folder1);
				orden_ficheros.add(folder2);
			}
			else {
				orden_ficheros.add(folder2);
				orden_ficheros.add(folder1);
			}
		}
			
			logger.debug(ficheros_folder1.length);
			logger.debug(ficheros_folder2.length);
		return orden_ficheros;
	}
	
	
	
	public ValorComparacion getValorComparacion (File file) throws GestionFicherosException {
		long fecha1 = 0;
		long fecha2 = 0;
		ValorComparacion valor = null;
		boolean encontrado1 = false;
		boolean encontrado2 = false;
		boolean sonDirectorios = setFolders(ruta1, ruta2); 
		if(sonDirectorios) {
			for (File g : ruta1.listFiles()) {
				if (g.getName().equals(file.getName())) {
					encontrado1 = true;
					fecha1 = g.lastModified();
				}
			}
			for (File w : ruta2.listFiles()) {
				if (w.getName().equals(file.getName())) {
					encontrado2 = true;
					fecha2 = w.lastModified();
				}
		}
			if (encontrado1 && !encontrado2) {
				valor = ValorComparacion.FALTA_EN_2;
			}
			else if (!encontrado1 && encontrado2) {
				valor = ValorComparacion.FALTA_EN_1;
			}
			else if (encontrado1 && encontrado2) {
				if (fecha1 > fecha2) {
					valor = ValorComparacion.MENOS_NUEVO_EN_1;
				}
				else if (fecha2 > fecha1){
					valor = ValorComparacion.MENOS_NUEVO_EN_2;
				}
				else {
					valor = ValorComparacion.IGUALES;
				}
		}
		}
		return valor;
	}
	
	
	
	public Set<ResultadoComparacion> compare() throws GestionFicherosException {
		Set<File> ficheros_orden = getNumFicheroPorDirectorio(ruta1,ruta2);
		for (File r : ficheros_orden) {
			File [] ficheros = r.listFiles();
			for (File f : ficheros) {
				ValorComparacion valor = getValorComparacion (f);
				ResultadoComparacion objeto = new ResultadoComparacion(f.getName(),f.lastModified(), valor);
				logger.info(objeto.toString());
			}
		}
		return null;
		
	}
}

