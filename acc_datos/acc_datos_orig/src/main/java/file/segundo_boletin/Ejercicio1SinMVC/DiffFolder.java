package file.segundo_boletin.Ejercicio1SinMVC;

import java.io.File;

public class DiffFolder {
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
	
	
	
	public void setFolders (File folder1, File folder2) throws GestionFicherosException {
		if (folder1.exists() && folder2.exists()) {
			boolean esDirectorio1 = folder1.isDirectory();
			boolean esDirectorio2 = folder2.isDirectory();
			if (!esDirectorio1 && !esDirectorio2) {
				throw new GestionFicherosException ("Las rutas dadas no son directorios");
			}
		}
	}
	
	
	
}
