package acceso.guzmanesSalud.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "constantes")
public class ConstantesVitales {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double frecuenciaCardiaca; 
    private double tension;   
    private double temperatura;       
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

	public ConstantesVitales(double frecuenciaCardiaca, double tension, double temperatura, LocalDateTime fechaRegistro,
			Paciente paciente) {
		super();
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.tension = tension;
		this.temperatura = temperatura;
		this.fechaRegistro = fechaRegistro;
		this.paciente = paciente;
	}

	public ConstantesVitales(double frecuenciaCardiaca, double tension, double temperatura,
			LocalDateTime fechaRegistro) {
		super();
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.tension = tension;
		this.temperatura = temperatura;
		this.fechaRegistro = fechaRegistro;
	}
    
    
}
