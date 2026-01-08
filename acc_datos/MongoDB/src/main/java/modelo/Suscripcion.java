package modelo;

import utils.TipoPlan;

public class Suscripcion {
	private boolean pendiente_cobro;
	private String fecha_cobro;
	private double precio;
	private TipoPlan tipo_plan;
	public boolean getPendiente_cobro() {
		return pendiente_cobro;
	}
	public void setPendiente_cobro(boolean pendiente_cobro) {
		this.pendiente_cobro = pendiente_cobro;
	}
	public String getFecha_cobro() {
		return fecha_cobro;
	}
	public void setFecha_cobro(String fecha_cobro) {
		this.fecha_cobro = fecha_cobro;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public TipoPlan getTipoPlan() {
		return tipo_plan;
	}
	public void setTipoPlan(TipoPlan tipoPlan) {
		this.tipo_plan = tipoPlan;
	}
	public Suscripcion(boolean pendiente_cobro, String fecha_cobro, double precio, TipoPlan tipoPlan) {
		super();
		this.pendiente_cobro = pendiente_cobro;
		this.fecha_cobro = fecha_cobro;
		this.precio = precio;
		this.tipo_plan = tipoPlan;
	}
	public Suscripcion() {
		super();
	}
	@Override
	public String toString() {
		return "Suscripcion [pendiente_cobro=" + pendiente_cobro + ", fecha_cobro=" + fecha_cobro + ", precio=" + precio
				+ ", tipoPlan=" + tipo_plan + "]";
	}
	
	
}
