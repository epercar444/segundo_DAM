package myapp.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.exceptions.LibroNotFoundException;
import myapp.models.Lector;
import myapp.models.Libro;
import myapp.repositories.LectorRepository;
import myapp.repositories.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private LectorRepository lectorRepository;
	
	
	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}

	public Libro createLibro(Libro libro) {
	    // Guarda el libro limpio, sin lectores
	    Set<Lector> lectoresOriginales = libro.getLectores();
	    libro.setLectores(new HashSet<>());
	    Libro libroGuardado = libroRepository.save(libro);

	    // Ahora asocia desde el lado dueño (Lector)
	    if (lectoresOriginales != null) {
	        for (Lector lector : lectoresOriginales) {
	            Lector lectorBD = lectorRepository.findById(lector.getId())
	                .orElseThrow();
	            
	            // Inicializa el set si es null
	            if (lectorBD.getLibros() == null) {
	                lectorBD.setLibros(new HashSet<>());
	            }
	            
	            lectorBD.getLibros().add(libroGuardado);
	            lectorRepository.save(lectorBD);
	        }
	    }
	    return libroGuardado;
	}

	@Override
	public Libro findLibroById(long id) {
	     Optional<Libro> optionalLibro = libroRepository.findById(id);
	        return optionalLibro.orElseThrow(() -> new LibroNotFoundException(id));
	}

	@Override
	public Libro updatepagTotalesLibro(long id, Libro l) {
	    Libro lOriginal = libroRepository.findById(id)
	        .orElseThrow(() -> new LibroNotFoundException(id));
	    lOriginal.setPagTotales(l.getPagTotales());
	    return libroRepository.save(lOriginal);
	}
}
