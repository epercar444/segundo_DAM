package psp.tema1.boletin2;

public class ProcesoHijo_CalculaSuma {
	public static void main(String[] args) {
		ProcesoHijo_CalculaSuma r = new ProcesoHijo_CalculaSuma();
		System.out.println(r.CalculaSuma(args));
	}
	
	public int CalculaSuma (String [] argumentos) {
		int sumaPar = 0;
		int sumaImpar = 0;
		int suma = 0;
		int numero = Integer.parseInt(argumentos[1]);
		String par_o_impar = argumentos[0].toLowerCase();
			for (int i = 0; i <= numero; i++) {
				if (par_o_impar.equals("par")) {
					if (i%2==0) {
						sumaPar = sumaPar + i;
						suma = sumaPar;
					}
			}
				else {
					if(i%3==0) {
						sumaImpar = sumaImpar + i;
						suma = sumaImpar;
					}
				}
		}
			return suma;
	}
}
