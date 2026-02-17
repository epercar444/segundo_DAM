package myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.exceptions.AutorNotFoundException;
import myapp.models.Autor;
import myapp.repositories.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}
	@Override
	public Autor createAutor(Autor autor) {
	    if (autor.getLibrosEscritos() != null) {
	        // Obligamos a cada libro a reconocer a este autor
	        autor.getLibrosEscritos().forEach(libro -> libro.setAutor(autor));
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
