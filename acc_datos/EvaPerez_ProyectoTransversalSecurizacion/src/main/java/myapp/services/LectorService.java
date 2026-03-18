package myapp.services;

import java.util.List;
import java.util.Set;

import myapp.models.Lector;

public interface LectorService {
	List<Lector>  findAll();
    public Lector createLector(Lector l) ;
    public Lector findLectorById(long id);
    public Lector updateLibrosLector (long id, Lector l);
    Set<Lector> findByUsuario(String usuario);
}
