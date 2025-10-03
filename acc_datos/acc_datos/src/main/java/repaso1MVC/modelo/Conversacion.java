package repaso1MVC.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

public class Conversacion {
	private String id, pregunta, respuesta;
	private int NumValoracionesPositivas;
	private LocalDate fecha_conversacion;
	private TipoAgente agente;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getNumValoracionesPositivas() {
		return NumValoracionesPositivas;
	}

	public void setNumValoracionesPositivas(int numValoracionesPositivas) {
		NumValoracionesPositivas = numValoracionesPositivas;
	}

	public LocalDate getFecha_conversacion() {
		return fecha_conversacion;
	}

	public void setFecha_conversacion(LocalDate fecha_conversacion) {
		this.fecha_conversacion = fecha_conversacion;
	}

	public TipoAgente getAgente() {
		return agente;
	}

	public void setAgente(TipoAgente agente) {
		this.agente = agente;
	}

	public Conversacion() {
		super();
	}


	public Conversacion(String pregunta, String respuesta, TipoAgente agente) {
		super();
		//this.id = this.calculaIdentificador();
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.agente = agente;
	}


	public Conversacion(String pregunta, String respuesta, int numValoracionesPositivas,
			LocalDate fecha_conversacion, TipoAgente agente) {
		super();
		//this.id = this.calculaIdentificador();
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		NumValoracionesPositivas = numValoracionesPositivas;
		this.fecha_conversacion = fecha_conversacion;
		this.agente = agente;
	}
	
	/*public String calculaIdentificador () {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("ddMMyyyy");
		String fecha_formateada = this.fecha_conversacion.format(formateador);
		Random random = new Random();
		int numero = random.nextInt(0,100);
		String numero_formateado = Integer.toString(numero);
		return fecha_formateada + numero_formateado;
	}*/


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conversacion other = (Conversacion) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Conversacion [id=" + id + ", pregunta=" + pregunta + ", respuesta=" + respuesta
				+ ", NumValoracionesPositivas=" + NumValoracionesPositivas + ", fecha_conversacion="
				+ fecha_conversacion + ", agente=" + agente + "]";
	}
	
	
	
}
