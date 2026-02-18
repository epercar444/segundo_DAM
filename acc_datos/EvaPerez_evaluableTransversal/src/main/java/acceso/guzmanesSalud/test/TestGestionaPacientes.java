package acceso.guzmanesSalud.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.services.PacientesServiceImpl;

public class TestGestionaPacientes {

	public static void main(String[] args) {
		PacientesServiceImpl servicio = new PacientesServiceImpl();
		
		ConstantesVitales c1 = new ConstantesVitales(2.2, 1.1, 3.3, LocalDateTime.now());
		ConstantesVitales c2 = new ConstantesVitales(1.1, 2.2, 3.3, LocalDateTime.now());
		ConstantesVitales c3 = new ConstantesVitales(2.2, 1.1, 3.3, LocalDateTime.now());
		
		List<ConstantesVitales> constantes1 = new ArrayList<>();
		constantes1.add(c1);
		List<ConstantesVitales> constantes2 = new ArrayList<>();
		constantes2.add(c2);

		
		
		Paciente p1 = new Paciente("Paciente Prueba 1", "12345678A", constantes1);
		Paciente p2 = new Paciente("Paciente Prueba 2", "87654321Z", constantes2);
		
		System.out.println(servicio.addPaciente(p1));

	}

}
