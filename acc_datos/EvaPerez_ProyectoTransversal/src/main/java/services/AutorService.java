package services;

import java.util.List;
import java.util.Set;

import models.Autor;

public interface AutorService {
	List<Autor>  findAll();
    public Autor createAutor(Autor a) ;
    public Autor findAutorById(long id);
    public Autor updateNameAutor (long id, Autor a);
}
