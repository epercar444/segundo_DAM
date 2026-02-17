package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.AutorNotFoundException;
import models.Autor;
import repositories.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}
	@Override
	public Autor createAutor(Autor a) {
		return autorRepository.save(a);
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
