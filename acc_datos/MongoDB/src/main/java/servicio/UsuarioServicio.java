package servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import modelo.Usuario;
import repositorio.UsuarioRepositorio;
import utils.AlreadyExistsException;
import utils.RolUsuario;
import utils.TipoPlan;


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
	
	
	//CRUD
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
	
	public void updateUser (int id, Usuario u) {
		try {
			repositorio.updateUser(id, u);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	//ORDENACIÓN
	public List<Usuario> ordenarXides () {
		List<Usuario> usuarios = repositorio.ordenarXId();
		return usuarios;
	}

	public void ordenarXnombre () {
		Collections.sort(repositorio.getUsuarios()); 
		for (Usuario u : repositorio.getUsuarios()) {
			logger.info(u);
		}
		//le damos la lista que queremos que ordene y la clase donde hemos implementado el comparator
	}
	
	//FILTRO
	public List<Usuario> filtroXRol (RolUsuario rol) {
		List<Usuario> usuariosRol = repositorio.filtrarXrol(rol);
		return usuariosRol;
	}
	
	public List<Usuario> filtroXTipoSuscripcion (TipoPlan plan,int numLibros) {
		List<Usuario> usuarios = new ArrayList<>();
		for (Usuario u : repositorio.getUsuarios()) {
			if (u.getSuscripcion().getTipoPlan().equals(plan) && u.getLibros().size() == numLibros){
				usuarios.add(u);
			}
			}
		return usuarios;
		}
	}
 
