package acceso.guzmanesSalud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.repositories.ConstantesRepository;
import acceso.guzmanesSalud.repositories.PacienteRepository;
import exceptions.PacienteNotFoundException;

@Service
public class PacientesServiceImpl implements PacientesService{
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private ConstantesRepository constantesRepository;
	
	
	
	@Override
	public Paciente findById(Long idPaciente) {
		Optional<Paciente> optionalPaciente = pacienteRepository.findById(idPaciente);
		return optionalPaciente.orElseThrow(() -> new PacienteNotFoundException(idPaciente));
	}

	@Override
	public Paciente addPaciente(Paciente paciente) {
		Paciente p = findById(paciente.getId());
		if (p!=null) {
			throw new PacienteNotFoundException(paciente.getId());
		}
		return pacienteRepository.save(paciente);
	}

	@Override
	public ConstantesVitales addConstantesVitales(Long id, ConstantesVitales constantes) {
		Paciente paciente = findById(id);
		List<ConstantesVitales> constantesVitales = paciente.getConstantesVitales();
		if (!constantesVitales.contains(constantes)) {
			constantesVitales.add(constantes);
		}
		return constantesRepository.save(constantes);
	}

	@Override
	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente updateConstantesPaciente(long id, Paciente paciente) {
    	Paciente pOriginal = this.findById(id);
    	if (pOriginal!=null) {
        	pOriginal.setConstantesVitales(paciente.getConstantesVitales());
    	}
    	else {
    		new PacienteNotFoundException(id);
    	}
    	return pacienteRepository.save(pOriginal);
    }

}
