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
		
		
		/*
		//ADD USER : creamos un nuevo usuario y lo añadimos nuestra base de datos
		// si intentamos añadir un usuario que ya existe saltará una excepción controlada
		Suscripcion suscripcion1 = new Suscripcion(false, "2023-10-01", 9.99, TipoPlan.PREMIUM_MENSUAL);
        Libro libro1 = new Libro("978-3-16-148410-0", "El Quijote", "Miguel de Cervantes", 500, true, GeneroLibro.NO_FICCION, EstadoLibro.LEIDO);
        List<Libro> libros1 = new ArrayList<>();
        libros1.add(libro1);
        Usuario usuario25 = new Usuario("JuanPerez", "juan.perez@email.com", 25, true, suscripcion1, libros1, RolUsuario.LECTOR);
        servicio.addUser(usuario25);*/
        /*
        //usuario excepción
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
		
		
		
        //GET USER (le pasamos el id del usuario: si existe, saldrá el usuario; si no existe, saldrá una excepción controlada y null
        //logger.info(servicio.getUser(25));
		
		
		//UPDATE USER (le pasamos el id del usuario a buscar y el nuevo usuario (importante que tenga el mismo id del reemplazado) y se reemplazará en la bbdd
		//si el id no existe saltará una excepción controlada
		/*Suscripcion suscripcionCarmen = new Suscripcion(false, "2025-12-08", 4.99, TipoPlan.PREMIUM_MENSUAL);
		Libro libroNaruto = new Libro("978-84-679-0466-0", "Naruto 01", "Masashi Kishimoto", 192, true, GeneroLibro.MANGA, EstadoLibro.LEIDO);
		Libro libroOnePiece = new Libro("978-84-679-0301-4", "One Piece 01", "Eiichiro Oda", 208, true, GeneroLibro.MANGA, EstadoLibro.LEIDO);
		List<Libro> bibliotecaCarmen = new ArrayList<>();
		bibliotecaCarmen.add(libroNaruto);
		bibliotecaCarmen.add(libroOnePiece);
		Usuario usuarioCarmen = new Usuario("Carmen_Manga", "carmen.m@email.com", 23, true, suscripcionCarmen, bibliotecaCarmen, RolUsuario.LECTOR);
		
		servicio.updateUser(23, usuarioCarmen);*/

		
		
		
		
		/*for (Usuario u : usuarios) {
		logger.info(u); 
		}*/
		
		
		//ORDENAR POR ID (Repositorio,Ascendente)
		/*List<Usuario> usuarios1 = servicio.ordenarXides();
		for (Usuario u : usuarios1) {
			logger.info(u);
		}*/
		
		
		//ORDENAR POR NOMBRE (Servicio,Descedente)
		//servicio.ordenarXnombre();
		
		
		//FILTRO POR ROL (Repositorio)
		/*List<Usuario> usuariosRol = servicio.filtroXRol(RolUsuario.ADMINISTRADOR);
		for (Usuario u : usuariosRol) {
			logger.info(u);
		}*/
		
		
		//FILTRO POR TIPO DE PLAN EN SUSCRIPCIÓN (Servicio)
		/*List<Usuario> usuariosTipoSuscripcion = servicio.filtroXTipoSuscripcion(TipoPlan.PREMIUM_ANUAL);
		for (Usuario u : usuariosTipoSuscripcion) {
			logger.info(u);
		}*/
		
		
	}
	
}
