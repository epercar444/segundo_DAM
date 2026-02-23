package myapp.services;

import java.util.List;
import java.util.Set;

import myapp.models.Autor;

public interface AutorService {
	List<Autor>  findAll();
    public Autor createAutor(Autor a) ;
    public Autor findAutorById(long id);
    public Autor updateNameAutor (long id, Autor a);
}
