package file.segundo_boletin.Ejercicio1SinMVC;

import java.time.LocalDate;
import java.util.Objects;

public class ResultadoComparacion{
	private String nombre_fichero;
	private long fecha_modificacion;
	private ValorComparacion valor_comparacion;
	public String getNombre_fichero() {
		return nombre_fichero;
	}
	public void setNombre_fichero(String nombre_fichero) {
		this.nombre_fichero = nombre_fichero;
	}
	public long getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(long fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public ValorComparacion getValor_comparacion() {
		return valor_comparacion;
	}
	public void setValor_comparacion(ValorComparacion valor_comparacion) {
		this.valor_comparacion = valor_comparacion;
	}
	public ResultadoComparacion(String nombre_fichero, long fecha_modificacion,
			ValorComparacion valor_comparacion) {
		super();
		this.nombre_fichero = nombre_fichero;
		this.fecha_modificacion = fecha_modificacion;
		this.valor_comparacion = valor_comparacion;
	}
	@Override
	public String toString() {
		return "ResultadoComparacion [nombre_fichero=" + nombre_fichero + ", fecha_modificacion=" + fecha_modificacion
				+ ", valor_comparacion=" + valor_comparacion + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre_fichero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoComparacion other = (ResultadoComparacion) obj;
		return Objects.equals(nombre_fichero, other.nombre_fichero);
	}
	
	
	
}
