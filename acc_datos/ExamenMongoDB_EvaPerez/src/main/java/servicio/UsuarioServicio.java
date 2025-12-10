package servicio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import modelo.Evento;
import modelo.Usuario;
import repositorio.UsuarioRepositorio;
import utils.AppException;

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
	
	//llamada métodos CRUD
	
	public void addUser (Usuario u) {
		try {
			repositorio.addUser(u);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuario getUser (String id) {
		Usuario u = null;
		try {
			u = repositorio.getUser(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public List<Usuario> orderBy () {
		return repositorio.orderBy();
	}
	
	//otros métodos
	
	public UpdateResult updateLanguage () {
		return repositorio.updateLanguage();
	}
	
	public DeleteResult deleteAnual () {
		return repositorio.deleteAnual();
	}
	
	public List<Usuario> getForCondition() {
		return repositorio.getForCondition();
	}
	
	public UpdateResult updatePlanActivo () {
		return repositorio.updatePlanActivo();
	}
	
	public UpdateResult addEvent (String id, Evento e) {
		return repositorio.addEvent(id, e);
	}
	
}
