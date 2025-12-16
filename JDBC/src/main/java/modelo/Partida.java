package modelo;

import java.sql.Date;
import java.util.Objects;

import utils.TipoResultado;

public class Partida {
	private static int contador = 1;
	private int id,torneo_id;
	private Jugador narrador;
	private Date fecha;
	private TipoResultado resultado;
	public Partida(Jugador narrador, Date fecha, TipoResultado resultado,int torneo_id) {
		super();
		//id autoincremental
		this.id = contador + id;
		this.narrador = narrador;
		this.fecha = fecha;
		this.resultado = resultado;
		this.torneo_id = torneo_id;
		contador++;
	}
	public Partida() {
		super();
	}
	public int getTorneo_id() {
		return torneo_id;
	}
	public void setTorneo_id(int torneo_id) {
		this.torneo_id = torneo_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Jugador getNarrador() {
		return narrador;
	}
	public void setNarrador(Jugador narrador) {
		this.narrador = narrador;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public TipoResultado getResultado() {
		return resultado;
	}
	public void setResultado(TipoResultado resultado) {
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return "Partida [id=" + id + ", torneo_id=" + torneo_id + ", narrador=" + narrador + ", fecha=" + fecha
				+ ", resultado=" + resultado + "]";
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
		Partida other = (Partida) obj;
		return id == other.id;
	}
	
	
}
