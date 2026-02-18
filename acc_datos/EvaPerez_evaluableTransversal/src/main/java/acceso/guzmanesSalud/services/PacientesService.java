package acceso.guzmanesSalud.services;

import java.util.List;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;

public interface PacientesService{
	public Paciente findById(Long idPaciente);
	public Paciente addPaciente (Paciente paciente);
	public ConstantesVitales addConstantesVitales(Long id,ConstantesVitales constantes);
	public List<Paciente> findAll(); //no lo pide en el enunciado pero si en el URL
    public Paciente updateConstantesPaciente (long id, Paciente paciente);
}
