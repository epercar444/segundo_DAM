package myapp.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.exceptions.AutorNotFoundException;
import myapp.models.Autor;
import myapp.models.Lector;
import myapp.repositories.AutorRepository;
import myapp.repositories.LectorRepository;

@Service
public class AutorServiceImpl implements AutorService{
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LectorRepository lectorRepository;
	
	@Override
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}
	@Override
	public Autor createAutor(Autor autor) {
	    if (autor.getLibrosEscritos() != null) {
	        autor.getLibrosEscritos().forEach(libro -> {
	            libro.setAutor(autor);
	            
	            // Persistir lectores nuevos antes de guardar
	            if (libro.getLectores() != null) {
	                Set<Lector> lectoresPersistidos = new HashSet<>();
	                for (Lector lector : libro.getLectores()) {
	                    if (lector.getId() == 0) {
	                        lector = lectorRepository.save(lector);
	                    }
	                    lectoresPersistidos.add(lector);
	                }
	                libro.setLectores(lectoresPersistidos);
	            }
	        });
	    }
	    return autorRepository.save(autor);
	}
	@Override
	public Autor findAutorById(long id) {
		Optional<Autor> optionalAutor = autorRepository.findById(id);
		return optionalAutor.orElseThrow(() -> new AutorNotFoundException(id));
	}
	@Override
	public Autor updateNameAutor(long id, Autor a) {
		Autor aOriginal = this.findAutorById(id);
		if (aOriginal != null) {
			aOriginal.setNombre(a.getNombre());
		}
		else {
			new AutorNotFoundException(id);
		}
		return autorRepository.save(aOriginal);
	}

}
