package myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.exceptions.LibroNotFoundException;
import myapp.models.Autor;
import myapp.models.Lector;
import myapp.models.Libro;
import myapp.repositories.AutorRepository;
import myapp.repositories.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}

	@Override
	public Libro createLibro(Libro libro) {
	    if (libro.getLectores() != null) {
	        for (Lector lector : libro.getLectores()) {
	            if (lector.getLibros() == null) {
	                lector.setLibros(new java.util.HashSet<>());
	            }
	            lector.getLibros().add(libro); 
	        }
	    }
	    return libroRepository.save(libro);
	}

	@Override
	public Libro findLibroById(long id) {
	     Optional<Libro> optionalLibro = libroRepository.findById(id);
	        return optionalLibro.orElseThrow(() -> new LibroNotFoundException(id));
	}

	@Override
	public Libro updatepagTotalesLibro(long id, Libro l) {
    	Libro lOriginal = this.findLibroById(id);
    	if (lOriginal!=null) {
        	lOriginal.setPagTotales(l.getPagTotales());
    	}
    	else {
    		new LibroNotFoundException(id);
    	}
    	return libroRepository.save(lOriginal);
	}
}
