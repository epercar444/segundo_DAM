package servicio;

import modelo.Valoracion;
import repositorio.RepositorioValoracion;

public class ServicioValoracion {
	RepositorioValoracion repo;

	public ServicioValoracion() {
		super();
		this.repo = new RepositorioValoracion();
	}
	
	public void addValoracion (Valoracion v) {
		repo.create(v);
	}
	
	public void removeValoracion (Valoracion v) {
		repo.delete(v);
	}
	
	public Valoracion getValoracion (int idValoracion) {
		return repo.get(idValoracion);
	}
	
	public void updateValoracion (Valoracion v) {
		repo.update(v);
	}
}
