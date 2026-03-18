package myapp.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.exceptions.LectorNotFoundException;
import myapp.models.Lector;
import myapp.repositories.LectorRepository;

@Service
public class LectorServiceImpl implements LectorService{
	@Autowired
	private LectorRepository lectorRepository;

	@Override
	public List<Lector> findAll() {
		return lectorRepository.findAll();
	}

	@Override
	public Lector createLector(Lector l) {
		return lectorRepository.save(l);
	}

	@Override
	public Lector findLectorById(long id) {
		Optional<Lector> optionalLector = lectorRepository.findById(id);
        return optionalLector.orElseThrow(() -> new LectorNotFoundException(id));
	}

	@Override
	public Lector updateLibrosLector(long id, Lector l) {
		Lector lOriginal = this.findLectorById(id);
		if (lOriginal!=null) {
			lOriginal.setLibros(l.getLibros());
		}
		else {
			new LectorNotFoundException(id);
		}
		return lectorRepository.save(lOriginal);
	}

	@Override
	public Set<Lector> findByUsuario(String usuario) {
		return lectorRepository.findByUsuario(usuario);
	}
	
}
