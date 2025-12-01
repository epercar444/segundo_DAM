package MongoDB.boletin2.servicio;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoDatabase;

import MongoDB.boletin2.modelo.Dispositivo;
import MongoDB.boletin2.repositorio.DispositivoRepositorio;

public class DispositivoServicio {
	private DispositivoRepositorio repo;

	public DispositivoRepositorio getRepo() {
		return repo;
	}

	public void setRepo(DispositivoRepositorio repo) {
		this.repo = repo;
	}

	public DispositivoServicio(MongoDatabase db) {
		super();
		this.repo = new DispositivoRepositorio(db);
	}
	
	public List<Dispositivo> read() {
		List<Dispositivo> dispositivos = repo.read();
		return dispositivos;
	}
	
	public List<Dispositivo> getXCategoria (String categoria) {
		List<Dispositivo> dispositivosXcategoria = new ArrayList<>();
		for (Dispositivo d : repo.getDispositivos()) {
			if (d.getCategoria().equalsIgnoreCase(categoria)) {
				dispositivosXcategoria.add(d);
			}
		}
		return dispositivosXcategoria;
	}
	
	
	public void addDispositivo(Dispositivo d) {
		repo.addDispositivo(d);
	}
	
	public void actualizaDispositivo(String nombre,int stock) {
		Dispositivo d = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i<repo.getDispositivos().size()) {
			if (repo.getDispositivos().get(i).getNombre().equalsIgnoreCase(nombre)) {
				d = repo.getDispositivos().get(i);
				d.setStock(stock);
				encontrado = true;
			}
			else {
				i++;
			}
		}
	}
}
