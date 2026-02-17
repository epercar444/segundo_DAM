package myapp.services;

import java.util.List;
import java.util.Set;

import myapp.models.Libro;

public interface LibroService {
	List<Libro>  findAll();
    public Libro createLibro(Libro l) ;
    public Libro findLibroById(long id);
    public Libro updatepagTotalesLibro (long id, Libro l);
}
