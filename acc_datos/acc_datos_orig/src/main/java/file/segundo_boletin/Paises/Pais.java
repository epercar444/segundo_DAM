package file.segundo_boletin.Paises;

public class Pais {
	private String nombre,continente,idioma,moneda;
	private int poblacion;
	//REPOSITORIO???
	public Pais(String nombre, String continente, String idioma, String moneda, int poblacion) {
		super();
		this.nombre = nombre;
		this.continente = continente;
		this.idioma = idioma;
		this.moneda = moneda;
		this.poblacion = poblacion;
	}
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", continente=" + continente + ", idioma=" + idioma + ", moneda=" + moneda
				+ ", poblacion=" + poblacion + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public int getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	
	
}
