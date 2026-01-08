package MongoDB.boletin2.modelo;

public class Especificacion {
	private String wifi,cobertura;
	private int unidades;
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getCobertura() {
		return cobertura;
	}
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public Especificacion(String wifi, String cobertura, int unidades) {
		super();
		this.wifi = wifi;
		this.cobertura = cobertura;
		this.unidades = unidades;
	}
	public Especificacion() {
		super();
	}
	@Override
	public String toString() {
		return "Especificacion [wifi=" + wifi + ", cobertura=" + cobertura + ", unidades=" + unidades + "]";
	}
	
}
