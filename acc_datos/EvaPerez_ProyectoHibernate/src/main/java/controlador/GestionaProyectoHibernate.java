package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Anotacion;
import modelo.Autor;
import modelo.Configuracion;
import modelo.Editorial;
import modelo.Lector;
import modelo.Libro;
import modelo.Valoracion;
import servicio.ServicioAnotacion;
import servicio.ServicioAutor;
import servicio.ServicioConfiguracion;
import servicio.ServicioEditorial;
import servicio.ServicioLector;
import servicio.ServicioLibro;
import servicio.ServicioValoracion;
import utils.TemaVisual;

public class GestionaProyectoHibernate {
    private static final Logger logger = LogManager.getLogger(GestionaProyectoHibernate.class);

    public static void main(String[] args) {
        //nos creamos los objetos de la clase servicio de cada una de las entidades
        ServicioAnotacion servicioAnotacion = new ServicioAnotacion();
        ServicioAutor servicioAutor = new ServicioAutor();
        ServicioConfiguracion servicioConfiguracion = new ServicioConfiguracion();
        ServicioEditorial servicioEditorial = new ServicioEditorial();
        ServicioLector servicioLector = new ServicioLector();
        ServicioLibro servicioLibro = new ServicioLibro();
        ServicioValoracion servicioValoracion = new ServicioValoracion();

        //creamos y añadimos todos los objetos a sus listas
        List<Libro> librosAutor1 = new ArrayList<>();
        List<Libro> librosAutor2 = new ArrayList<>();
        Autor au1 = new Autor("Miguel de Cervantes", "España", librosAutor1);
        Autor au2 = new Autor("Gabriel García Márquez", "Colombia", librosAutor2);

        List<Libro> librosEd1 = new ArrayList<>();
        List<Libro> librosEd2 = new ArrayList<>();
        Editorial ed1 = new Editorial("Editorial Planeta", "España", librosEd1);
        Editorial ed2 = new Editorial("Penguin Books", "Reino Unido", librosEd2);

        Configuracion conf1 = new Configuracion("Español", TemaVisual.OSCURO, true, null);
        Configuracion conf2 = new Configuracion("Inglés", TemaVisual.CLARO, false, null);

        List<Anotacion> anotacionesLec1 = new ArrayList<>();
        List<Valoracion> valoracionesLec1 = new ArrayList<>();
        Set<Libro> librosPropiedadLec1 = new HashSet<>();
        Lector lec1 = new Lector("juan_cervantes", "pass123", conf1, anotacionesLec1, valoracionesLec1, librosPropiedadLec1);
        conf1.setLector(lec1);

        List<Anotacion> anotacionesLec2 = new ArrayList<>();
        List<Valoracion> valoracionesLec2 = new ArrayList<>();
        Set<Libro> librosPropiedadLec2 = new HashSet<>();
        Lector lec2 = new Lector("maria_gabo", "root456", conf2, anotacionesLec2, valoracionesLec2, librosPropiedadLec2);
        conf2.setLector(lec2);

        List<Anotacion> anotacionesLib1 = new ArrayList<>();
        List<Valoracion> valoracionesLib1 = new ArrayList<>();
        Set<Lector> lectoresLib1 = new HashSet<>();
        Libro lib1 = new Libro("Don Quijote", 1000, anotacionesLib1, valoracionesLib1, au1, ed1, lectoresLib1);
        librosAutor1.add(lib1);
        librosEd1.add(lib1);
        librosPropiedadLec1.add(lib1);
        lectoresLib1.add(lec1);

        List<Anotacion> anotacionesLib2 = new ArrayList<>();
        List<Valoracion> valoracionesLib2 = new ArrayList<>();
        Set<Lector> lectoresLib2 = new HashSet<>();
        Libro lib2 = new Libro("Cien años de soledad", 450, anotacionesLib2, valoracionesLib2, au2, ed2, lectoresLib2);
        librosAutor2.add(lib2);
        librosEd2.add(lib2);
        librosPropiedadLec2.add(lib2);
        lectoresLib2.add(lec2);

        List<Anotacion> anotacionesLib3 = new ArrayList<>();
        List<Valoracion> valoracionesLib3 = new ArrayList<>();
        Set<Lector> lectoresLib3 = new HashSet<>();
        Libro lib3 = new Libro("La Galatea", 500, anotacionesLib3, valoracionesLib3, au1, ed2, lectoresLib3);
        librosAutor1.add(lib3);
        librosEd2.add(lib3);
        librosPropiedadLec1.add(lib3);
        lectoresLib3.add(lec1);

        List<Anotacion> anotacionesLib4 = new ArrayList<>();
        List<Valoracion> valoracionesLib4 = new ArrayList<>();
        Set<Lector> lectoresLib4 = new HashSet<>();
        Libro lib4 = new Libro("El coronel no tiene quien le escriba", 150, anotacionesLib4, valoracionesLib4, au2, ed1, lectoresLib4);
        librosAutor2.add(lib4);
        librosEd1.add(lib4);
        librosPropiedadLec2.add(lib4);
        lectoresLib4.add(lec2);

        Anotacion an1 = new Anotacion("Nota importante sobre el capítulo 1", 12, lec1, lib1);
        anotacionesLec1.add(an1);
        anotacionesLib1.add(an1);
        Anotacion an2 = new Anotacion("Referencia bibliográfica clave", 245, lec2, lib2);
        anotacionesLec2.add(an2);
        anotacionesLib2.add(an2);
        Anotacion an3 = new Anotacion("Estilo pastoral muy marcado", 40, lec1, lib3);
        anotacionesLec1.add(an3);
        anotacionesLib3.add(an3);
        Anotacion an4 = new Anotacion("Análisis del realismo mágico", 100, lec2, lib4);
        anotacionesLec2.add(an4);
        anotacionesLib4.add(an4);

        Valoracion val1 = new Valoracion(5, "La mejor obra de la lengua castellana", LocalDate.now(), lib1, lec1);
        valoracionesLec1.add(val1);
        valoracionesLib1.add(val1);
        Valoracion val2 = new Valoracion(4, "Una narrativa mágica inigualable", LocalDate.now(), lib2, lec2);
        valoracionesLec2.add(val2);
        valoracionesLib2.add(val2);
        Valoracion val3 = new Valoracion(3, "Lectura interesante pero densa", LocalDate.now(), lib3, lec1);
        valoracionesLec1.add(val3);
        valoracionesLib3.add(val3);
        Valoracion val4 = new Valoracion(5, "Breve y desgarradora", LocalDate.now(), lib4, lec2);
        valoracionesLec2.add(val4);
        valoracionesLib4.add(val4);

        //guardar primero Autor, Editorial y Lector
        servicioAutor.addAutor(au1);
        servicioAutor.addAutor(au2);

        servicioEditorial.addEditorial(ed1);
        servicioEditorial.addEditorial(ed2);

        servicioLibro.addLibro(lib1);
        servicioLibro.addLibro(lib2);
        servicioLibro.addLibro(lib3);
        servicioLibro.addLibro(lib4);

        servicioLector.addLector(lec1);
        servicioLector.addLector(lec2);

        //guardar Anotaciones
        servicioAnotacion.addAnotacion(an1);
        servicioAnotacion.addAnotacion(an2);
        servicioAnotacion.addAnotacion(an3);
        servicioAnotacion.addAnotacion(an4);

        //guardar Valoraciones
        servicioValoracion.addValoracion(val1);
        servicioValoracion.addValoracion(val2);
        servicioValoracion.addValoracion(val3);
        servicioValoracion.addValoracion(val4);

        //actualizamos la información
        au1.setNombre("Miguel de Cervantes Saavedra");
        servicioAutor.updateAutor(au1);

        ed1.setNombre("Editorial Planeta Actualizada");
        servicioEditorial.updateEditorial(ed1);

        lec1.setUsername("juan_cervantes_mod");
        servicioLector.updateLector(lec1);

        lib1.setTitulo("Don Quijote de la Mancha");
        servicioLibro.updateLibro(lib1);

        conf1.setTemaVisual(TemaVisual.CLARO);
        servicioConfiguracion.updateConfiguracion(conf1);

        an1.setDescripcion("Nota corregida sobre el capítulo 1");
        servicioAnotacion.updateAnotacion(an1);

        val1.setComentario("Comentario actualizado");
        servicioValoracion.updateValoracion(val1);

        //eliminamos un objeto por cada modelo

        lec1.getLibros().remove(lib3); 
        lec1.getAnotaciones().remove(an3);
        lec1.getValoraciones().remove(val3);
        servicioLector.updateLector(lec1); 

        servicioAnotacion.removeAnotacion(an2);
        servicioAnotacion.removeAnotacion(an3);
        servicioAnotacion.removeAnotacion(an4);

        servicioValoracion.removeValoracion(val2);
        servicioValoracion.removeValoracion(val3);
        servicioValoracion.removeValoracion(val4);

        servicioLector.removeLector(lec2);

        servicioConfiguracion.removeConfiguracion(conf2);

        servicioLibro.removeLibro(lib2);
        servicioLibro.removeLibro(lib3);
        servicioLibro.removeLibro(lib4);

        servicioAutor.removeAutor(au2);
        servicioEditorial.removeEditorial(ed2);
    }
}