package modelo;

import java.util.Objects;

public class Retrans {
	private int id_retrans;
	private int duracion;
	public Retrans(int id_retrans, int duracion) {
		super();
		this.id_retrans = id_retrans;
		this.duracion = duracion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(duracion, id_retrans);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retrans other = (Retrans) obj;
		return duracion == other.duracion && id_retrans == other.id_retrans;
	}
	public int getId_retrans() {
		return id_retrans;
	}
	public void setId_retrans(int id_retrans) {
		this.id_retrans = id_retrans;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		return "retrans [id_retrans=" + id_retrans + ", duracion=" + duracion + "]";
	}
	
	
	
}
