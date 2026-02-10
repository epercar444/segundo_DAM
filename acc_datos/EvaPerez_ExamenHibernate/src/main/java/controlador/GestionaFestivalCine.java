package controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Cine;
import modelo.Pelicula;
import modelo.Sala;
import servicio.Servicio;

public class GestionaFestivalCine {
    private static final Logger logger = LogManager.getLogger(GestionaFestivalCine.class);

    public static void main(String[] args) {
        Servicio servicio = new Servicio();

        // 1. CREACIÓN DE PELÍCULAS
        Pelicula p1 = new Pelicula("Pelicula 1", "Genero1", 123, null);
        Pelicula p2 = new Pelicula("Pelicula 2", "Genero2", 280, null);
        Pelicula p3 = new Pelicula("Pelicula 3", "Genero3", 350, null);
        Pelicula p4 = new Pelicula("Pelicula 4", "Genero4", 107, null);
        Pelicula p5 = new Pelicula("Pelicula 5", "Genero5", 159, null);

        // Agrupamos películas para las salas
        Set<Pelicula> pelisS1 = new HashSet<>(); pelisS1.add(p1);
        Set<Pelicula> pelisS2 = new HashSet<>(); pelisS2.add(p1); pelisS2.add(p2);
        Set<Pelicula> pelisS3 = new HashSet<>(); pelisS3.add(p3);
        Set<Pelicula> pelisS4 = new HashSet<>(); pelisS4.add(p4); pelisS4.add(p5);

        // 2. CREACIÓN DE CINES (Primero, con lista de salas vacía)
        // Esto permite que el objeto Cine ya exista en memoria para asignarlo a las salas
        Cine cine1 = new Cine("Madrid", "Cine Capital", new ArrayList<Sala>());
        Cine cine2 = new Cine("Sevilla", "Cine Sur", new ArrayList<Sala>());

        // 3. CREACIÓN DE SALAS (Pasando el objeto Cine correspondiente)
        // IMPORTANTE: Debes haber actualizado el constructor en Sala.java para aceptar 'Cine'
        Sala sala1 = new Sala("Sala 1", 32, cine1, pelisS1);
        Sala sala2 = new Sala("Sala 2", 45, cine1, pelisS2);
        Sala sala3 = new Sala("Sala 3", 23, cine2, pelisS3);
        Sala sala4 = new Sala("Sala 4", 18, cine2, pelisS4);

        // 4. VINCULAR LAS SALAS A LOS CINES (Bidireccionalidad)
        // Como Cine tiene CascadeType.ALL, al guardar el cine se guardarán sus salas
        cine1.getSalas().add(sala1);
        cine1.getSalas().add(sala2);
        
        cine2.getSalas().add(sala3);
        cine2.getSalas().add(sala4);

        // 5. GUARDAR EN BASE DE DATOS
        // Esto guardará el Cine y, por cascada, las Salas con su 'idCine' correctamente relleno
        try {
            servicio.addCine(cine1);
            servicio.addCine(cine2);
            System.out.println("Cines y salas guardados correctamente con sus relaciones.");
        } catch (Exception e) {
            logger.error("Error al persistir los datos: " + e.getMessage());
        }
    }
}