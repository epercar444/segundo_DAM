package servicio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import modelo.Usuario;
import repositorio.UsuarioRepositorio;
import utils.AlreadyExistsException;


public class UsuarioServicio {
	private static final Logger logger = LogManager.getLogger(UsuarioServicio.class);
	private UsuarioRepositorio repositorio;
	public UsuarioRepositorio getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(UsuarioRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	public UsuarioServicio() {
		super();
	}
	public UsuarioServicio(MongoDatabase db) {
		super();
		this.repositorio = new UsuarioRepositorio(db);
	}
	
	public List<Usuario> read() {
		return repositorio.read();
	}
	
	public void addUser (Usuario u) {
		try {
			repositorio.addUser(u);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public void deleteUser(Usuario u) {
		try {
			repositorio.deleteUser(u);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public Usuario getUser (int id) {
		Usuario usuario = null;
		try {
			usuario = repositorio.getUser(id);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return usuario;
	}
 
}
