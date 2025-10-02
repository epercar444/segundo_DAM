package modelo;

import java.time.LocalDate;

public class Deportivo extends Evento{
	
	boolean son_televisados;
	
	public Deportivo(int num_entradas_vendidas, int cap_max_asist, String nombre, LocalDate fecha,
			Estado_Crafters estado, boolean son_televisados) throws CraftersException {
		super(num_entradas_vendidas, cap_max_asist, nombre, fecha, estado);
		// TODO Auto-generated constructor stub
		this.son_televisados = son_televisados;
	}
	
	public boolean isSon_televisados() {
		return son_televisados;
	}


	public void setSon_televisados(boolean son_televisados) {
		this.son_televisados = son_televisados;
	}


	@Override
	public double calcularCosteBase() {
		double alquiler_estadio = 0;
		double gastos_televisados = 0;
		if (cap_max_asist > 3000) {
			alquiler_estadio = 150000;
		}
		else {
			alquiler_estadio =  75000;
		}
		
		if (son_televisados) {
			gastos_televisados = 1000;
		}
		
		double costeBase = alquiler_estadio - gastos_televisados;
		return costeBase;
	}

}
