package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.LibroNotFoundException;
import models.Libro;
import repositories.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{
	@Autowired
	private LibroRepository libroRepository;

	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}

	@Override
	public Libro createLibro(Libro l) {
		return libroRepository.save(l);
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
