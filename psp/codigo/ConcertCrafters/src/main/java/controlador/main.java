package controlador;

import java.time.LocalDate;

import modelo.Concierto;
import modelo.CraftersException;
import modelo.Deportivo;
import modelo.Estado_Crafters;
import modelo.Evento;

public class main {

	public static void main(String[] args) {
		//1.
		System.out.println("Ejercicio 1:");
		try {
			Evento d1 = new Deportivo(600, 500, null, null, null, false);
		} catch (CraftersException e) {
			System.out.println(e.getMessage());	  }
		
		
		//2
		System.out.println("Ejercicio 2:");
		 try {
			Concierto c1 = new Concierto(200, 500, "RockFest", LocalDate.now(), Estado_Crafters.APLAZADO, "Queen", new String[]{"Artista1", "Artista2"}, 10000.0, 20000.0);
			c1.getPorcentajeOcupacion(50);
			System.out.println(c1.toString());
			c1.modificaEstado(Estado_Crafters.PROGRAMADO);
			System.out.println(c1.toString());
		} catch (CraftersException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		
		 //3
		 System.out.println("Ejercicio 3:");
		try {
			Concierto c2 = new Concierto(500, 500, "LiveShow", LocalDate.now(), Estado_Crafters.PENDIENTE, "Coldplay", new String[]{"Artista1", "Artista2"}, 15000.0, 30000.0);
			System.out.println(c2.calcularCosteBase());
			c2.getPorcentajeOcupacion();
			c2.getPorcentajeOcupacion(50);
		} catch (CraftersException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		//4
		System.out.println("Ejercicio 4:");
		try {
			Deportivo d2 = new Deportivo(1000, 5000, "Final Liga", LocalDate.now(), Estado_Crafters.CANCELADO, true);
			System.out.println(d2.calcularCosteBase());
			System.out.println(d2.toString());
		} catch (CraftersException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		//5
		System.out.println("Ejercicio 5:");
		try {
			Deportivo d3 = new Deportivo(100, 500, "Partido Local", LocalDate.now(), Estado_Crafters.PENDIENTE, true);
			d3.modificaEstado(Estado_Crafters.PROGRAMADO);
			System.out.println(d3.toString());
		} catch (CraftersException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}


		//6
		System.out.println("Ejercicio 6:");
		try {
			Deportivo d4 = new Deportivo(0, 5000, "Final Copa", LocalDate.now(), Estado_Crafters.CANCELADO, false);
			d4.modificaEstado(Estado_Crafters.PENDIENTE);
		} catch (CraftersException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
