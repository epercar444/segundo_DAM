package servicio;

import modelo.Configuracion;
import repositorio.RepositorioConfiguracion;

public class ServicioConfiguracion {
	RepositorioConfiguracion repo;

	public ServicioConfiguracion() {
		super();
		this.repo = new RepositorioConfiguracion();
	}
	
	public void addConfiguracion (Configuracion c) {
		repo.create(c);
	}
	
	public void removeConfiguracion (Configuracion c) {
		repo.delete(c);
	}
	
	public Configuracion getConfiguracion (int idConfiguracion) {
		return repo.get(idConfiguracion);
	}
	
	public void updateConfiguracion (Configuracion c) {
		repo.update(c);
	}
}
