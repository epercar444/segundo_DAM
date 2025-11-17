package psp.tema2.boletin1;

public class Ejercicico5Mascota implements Runnable{
	private int numVecesCome;
	private String nombre;

	public Ejercicico5Mascota(String nombre) {
		super();
		this.numVecesCome = 0;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumVecesCome() {
		return numVecesCome;
	}

	public void setNumVecesCome(int numVecesCome) {
		this.numVecesCome = numVecesCome;
	}

	@Override
	public void run() {
		int vecesComer = comer();
		try {
			Thread.sleep(1000);
			System.out.println("La mascota con nombre "+nombre+" ha terminado de comer: "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private int comer() {
		int numVecesComer = numVecesCome++;
		System.out.println("La mascota "+nombre+" ha empezado a comer:"+Thread.currentThread().getName());
		return numVecesComer;
	}

}
