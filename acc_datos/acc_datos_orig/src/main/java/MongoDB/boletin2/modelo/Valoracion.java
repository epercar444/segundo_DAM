package MongoDB.boletin2.modelo;

public class Valoracion {
	private String usuario,comentario;
	private double puntuacion;
	public Valoracion(String usuario, String comentario, double puntuacion) {
		super();
		this.usuario = usuario;
		this.comentario = comentario;
		this.puntuacion = puntuacion;
	}
	public Valoracion() {
		super();
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	@Override
	public String toString() {
		return "Valoracion [usuario=" + usuario + ", comentario=" + comentario + ", puntuacion=" + puntuacion + "]";
	}
	
}
