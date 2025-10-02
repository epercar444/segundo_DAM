package modelo;

import java.time.LocalDate;

public class Concierto extends Evento{
	
	String artista_principal;
	String[] invitados;
	double alquiler_ubicacion;
	double alquiler_principal;

	public Concierto(int num_entradas_vendidas, int cap_max_asist, String nombre, LocalDate fecha,
			Estado_Crafters estado, String artista_principal, String[] invitados, double alquiler_ubicacion, double alquiler_principal) throws CraftersException {
		super(num_entradas_vendidas, cap_max_asist, nombre, fecha, estado);
		this.artista_principal = artista_principal;
		this.invitados = new String [10];
		this.alquiler_ubicacion = alquiler_ubicacion;
		this.alquiler_principal = alquiler_principal;
	}
	

	public String getArtista_principal() {
		return artista_principal;
	}

	public void setArtista_principal(String artista_principal) {
		this.artista_principal = artista_principal;
	}

	public String[] getInvitados() {
		return invitados;
	}

	public void setInvitados(String[] invitados) {
		this.invitados = invitados;
	}

	public double getAlquiler_ubicacion() {
		return alquiler_ubicacion;
	}
	public void setAlquiler_ubicacion(double alquiler_ubicacion) {
		this.alquiler_ubicacion = alquiler_ubicacion;
	}


	@Override
	public double calcularCosteBase() {
		double costeBase = alquiler_ubicacion + alquiler_principal + (500*invitados.length);
		return costeBase;
	}

}
