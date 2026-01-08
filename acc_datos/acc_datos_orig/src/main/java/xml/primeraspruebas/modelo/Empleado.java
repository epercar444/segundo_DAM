package xml.primeraspruebas.modelo;

public class Empleado {
	private int edad;
	private String nombreApellido,empresa,identificador;
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String id) {
		this.identificador = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombreApellido() {
		return nombreApellido;
	}
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	@Override
	public String toString() {
		return "Empleado [identificador=" + identificador + ", edad=" + edad + ", nombreApellido=" + nombreApellido
				+ ", empresa=" + empresa + "]";
	}
	
}
