package psp.tema3.boletin2.ejercicio4;

import java.util.Arrays;

public class Tablero {
	String[][] tablero;

	public String[][] getTablero() {
		return tablero;
	}

	public void setTablero(String[][] tablero) {
		this.tablero = tablero;
	}

	public Tablero() {
		super();
		this.tablero = new String[3][4];
		tablero[0][0] = "Crucero";
		tablero[1][2] = "Entradas";
		tablero[2][0] = "Masaje";
		tablero[2][3] = "1000€";
	}

	@Override
	public String toString() {
		return "Tablero [tablero=" + Arrays.toString(tablero) + "]";
	}
	
	
	

}
