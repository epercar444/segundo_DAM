package modelo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import utils.TemaVisual;

@Entity
@Table(name = "configuracion")
public class Configuracion {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idConfiguracion; 
	
	private String idioma;
	private TemaVisual temaVisual;
	private boolean notificaciones;
	
	@OneToOne (mappedBy = "configuracion")
	private Lector lector;

	public int getIdConfiguracion() {
		return idConfiguracion;
	}

	public void setIdConfiguracion(int id) {
		this.idConfiguracion = id;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public TemaVisual getTemaVisual() {
		return temaVisual;
	}

	public void setTemaVisual(TemaVisual temaVisual) {
		this.temaVisual = temaVisual;
	}

	public boolean isNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(boolean notificaciones) {
		this.notificaciones = notificaciones;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idConfiguracion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuracion other = (Configuracion) obj;
		return idConfiguracion == other.idConfiguracion;
	}

	public Configuracion(String idioma, TemaVisual temaVisual, boolean notificaciones, Lector lector) {
		super();
		this.idioma = idioma;
		this.temaVisual = temaVisual;
		this.notificaciones = notificaciones;
		this.lector = lector;
	}

	public Configuracion() {
		super();
	}

	@Override
	public String toString() {
		return "Configuracion [id=" + idConfiguracion + ", idioma=" + idioma + ", temaVisual=" + temaVisual + ", notificaciones="
				+ notificaciones + "]";
	}
	
	
	
	
}
