package file.TowerGPT.modelo;

import java.util.Objects;

import file.TowerGPT.Exceptions.SetValidacionException;
import file.TowerGPT.modelo.TipoAgenteEnum.TipoAgente;

public class InteraccionAgente implements Comparable<InteraccionAgente>{
	private static int contador = 1;
	private int id,porcentaje_Acierto;
	private TipoAgente tipoAgente;
	private String peticion,respuesta;
	private float valoracion;
	
	public InteraccionAgente(int porcentaje_Acierto, TipoAgente tipoAgente, String peticion, String respuesta,
			float valoracion) {
		super();
		this.id = contador;
		this.porcentaje_Acierto = porcentaje_Acierto;
		this.tipoAgente = tipoAgente;
		this.peticion = peticion;
		this.respuesta = respuesta;
		this.valoracion = valoracion;
		contador++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoAgente getTipoAgente() {
		return tipoAgente;
	}
	public void setTipoAgente(TipoAgente tipoAgente) {
		this.tipoAgente = tipoAgente;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public float getValoracion() {
		return valoracion;
	}
	public void setValoracion(float valoracion) throws SetValidacionException {
		if (valoracion > 5 || valoracion < 0) {
			throw new SetValidacionException ("La valoración debe ser un número entre 0 y 5");
		}
		this.valoracion = valoracion;
	}
	public int getPorcentaje_Acierto() {
		return porcentaje_Acierto;
	}
	public void setPorcentaje_Acierto(int porcentaje_Acierto) {
		this.porcentaje_Acierto = porcentaje_Acierto;
	}
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
		InteraccionAgente other = (InteraccionAgente) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "InteraccionAgente [id=" + id + ", porcentaje_Acierto=" + porcentaje_Acierto + "%" + ", tipoAgente="
				+ tipoAgente + ", peticion=" + peticion + ", respuesta=" + respuesta + ", valoracion=" + valoracion
				+ "]";
	}
	@Override
	public int compareTo(InteraccionAgente o) {
		return Float.compare(o.getPorcentaje_Acierto(), porcentaje_Acierto);
	}
	
	
}
