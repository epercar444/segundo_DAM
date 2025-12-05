package modelo;

import java.time.LocalDate;
import java.util.Objects;

import utils.TipoResultado;

public class Partida {
	private int id;
	private Jugador narrador;
	private LocalDate fecha;
	private TipoResultado resultado;
	public Partida(int id, Jugador narrador, LocalDate fecha, TipoResultado resultado) {
		super();
		this.id = id;
		this.narrador = narrador;
		this.fecha = fecha;
		this.resultado = resultado;
	}
	public Partida() {
		super();
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
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
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
		return "Partida [id=" + id + ", narrador=" + narrador + ", fecha=" + fecha + ", resultado=" + resultado + "]";
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
