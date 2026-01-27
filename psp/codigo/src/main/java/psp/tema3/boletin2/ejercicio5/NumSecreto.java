package psp.tema3.boletin2.ejercicio5;

import java.util.Random;

public class NumSecreto {
    int numSecreto;
    boolean acertado = false; // Añadido para avisar a todos

    public NumSecreto() {
        // Generamos el número una sola vez al empezar el servidor
        this.numSecreto = new Random().nextInt(101);
    }
}