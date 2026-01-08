package MongoDB.simulacion.modelo;

public class Ubicacion {
	private String calle,codigoPostal;
	private int numero;
	private Coordenada coordenadas;
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Coordenada getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}
	public Ubicacion(String calle, String codigoPostal, int numero, Coordenada coordenadas) {
		super();
		this.calle = calle;
		this.codigoPostal = codigoPostal;
		this.numero = numero;
		this.coordenadas = coordenadas;
	}
	public Ubicacion() {
		super();
	}
	@Override
	public String toString() {
		return "Ubicacion [calle=" + calle + ", codigoPostal=" + codigoPostal + ", numero=" + numero + ", coordenadas="
				+ coordenadas + "]";
	}
	
	
}
