package controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import configuracion.MongoDBConexion;
import modelo.Libro;
import modelo.Suscripcion;
import modelo.Usuario;
import servicio.UsuarioServicio;
import utils.EstadoLibro;
import utils.GeneroLibro;
import utils.RolUsuario;
import utils.TipoPlan;



public class GestionaUsuarios {
	private static final Logger logger = LogManager.getLogger(GestionaUsuarios.class);
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();
		UsuarioServicio servicio = new UsuarioServicio(db);
		
		List<Usuario> usuarios = servicio.read();
		
		/*for (Usuario u : usuarios) {
			logger.info(u); //prueba para ver que salen los usuarios
		}*/
		
		
		
		/*ADD USER
		 * Suscripcion suscripcion1 = new Suscripcion(false, "2023-10-01", 9.99, TipoPlan.PREMIUM_MENSUAL);
        Libro libro1 = new Libro("978-3-16-148410-0", "El Quijote", "Miguel de Cervantes", 500, true, GeneroLibro.NO_FICCION, EstadoLibro.LEIDO);
        List<Libro> libros1 = new ArrayList<>();
        libros1.add(libro1);
        Usuario usuario25 = new Usuario("JuanPerez", "juan.perez@email.com", 25, true, suscripcion1, libros1, RolUsuario.LECTOR);
       //creamos un nuevo usuario y lo añadimos a nuestra base de datos
        servicio.addUser(usuario25);
        
        //intentamos añadir un usuario que ya existe y nos saltará una excepción controlada
		Suscripcion suscripcionCarmen = new Suscripcion(false, "2025-12-08", 4.99, TipoPlan.PREMIUM_MENSUAL);
        Libro libroNaruto = new Libro("978-84-679-0466-0", "Naruto 01", "Masashi Kishimoto", 192, true, GeneroLibro.MANGA, EstadoLibro.LEIDO);
        List<Libro> bibliotecaCarmen = new ArrayList<>();
        bibliotecaCarmen.add(libroNaruto);
        Usuario usuarioCarmen = new Usuario("Carmen_Manga", "carmen.m@email.com", 23, true, suscripcionCarmen, bibliotecaCarmen, RolUsuario.LECTOR);
        servicio.addUser(usuarioCarmen);*/
		
		
		//DELETE USER (nos creamos el mismo usuario que hemos metido antes, lo eliminará y si una vez eliminado intentas volver a borrarlo saltará la excepción
		 /* Suscripcion suscripcion1 = new Suscripcion(false, "2023-10-01", 9.99, TipoPlan.PREMIUM_MENSUAL);
        Libro libro1 = new Libro("978-3-16-148410-0", "El Quijote", "Miguel de Cervantes", 500, true, GeneroLibro.NO_FICCION, EstadoLibro.LEIDO);
        List<Libro> libros1 = new ArrayList<>();
        libros1.add(libro1);
        Usuario usuario25 = new Usuario("JuanPerez", "juan.perez@email.com", 25, true, suscripcion1, libros1, RolUsuario.LECTOR);
        servicio.deleteUser(usuario25);*/
		
		
		
		Suscripcion suscripcionCarmen = new Suscripcion(false, "2025-12-08", 4.99, TipoPlan.PREMIUM_MENSUAL);
        Libro libroNaruto = new Libro("978-84-679-0466-0", "Naruto 01", "Masashi Kishimoto", 192, true, GeneroLibro.MANGA, EstadoLibro.LEIDO);
        List<Libro> bibliotecaCarmen = new ArrayList<>();
        bibliotecaCarmen.add(libroNaruto);
        Usuario usuarioCarmen = new Usuario("Carmen_Manga", "carmen.m@email.com", 23, true, suscripcionCarmen, bibliotecaCarmen, RolUsuario.LECTOR);
        
        logger.info(servicio.getUser(23));
		
		
		
		
		
		/*for (Usuario u : usuarios) {
		logger.info(u); 
		}*/
		
		
	}
	
}
