package repositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import modelo.Evento;
import modelo.Preferencias;
import modelo.Usuario;
import utils.AppException;
import utils.PlanActivo;

public class UsuarioRepositorio {
	  private static final String NOMBRE_COLECCION = "usuarios";
	  private final MongoCollection<Document> coleccion;
	  private List<Usuario> usuarios;
	  
	   public UsuarioRepositorio(MongoDatabase db) {
	       this.coleccion = db.getCollection(NOMBRE_COLECCION);
	       this.usuarios = this.read();
	   }

	   public List<Usuario> getUsuarios() {
		   return usuarios;
	   }

	   public void setUsuarios(List<Usuario> usuarios) {
		   this.usuarios = usuarios;
	   }
	   
		public void save(Usuario u) {
	        Document doc = userToDocument(u);
	        coleccion.insertOne(doc);
	    }
	   
		private Document userToDocument(Usuario u) { 
		       Document doc = new Document("id", u.getId())
		               .append("username", u.getUsername())
		               .append("email", u.getEmail())
		               .append("plan_activo", u.getPlan_activo().toString())
		               .append("dispositivo", u.getDispositivo())
		               .append("preferencias", preferenciasToDocument(u))
		               .append("logs_eventos", eventosToDocuments(u));
		       return doc;
			}
	   
		private Document preferenciasToDocument (Usuario u) {
		       Document docPreferencias = new Document() 
		    		   .append("tema_oscuro", u.getPreferencias().isTema_oscuro())
		    		   .append("idioma", u.getPreferencias().getIdioma())
		    		   .append("notificaciones_push", u.getPreferencias().isNotificaciones_push())
		    		   .append("limite_datos_moviles", u.getPreferencias().isLimite_datos_moviles());
		       return docPreferencias;
		}
		
		private List<Document> eventosToDocuments(Usuario u) {
		    List<Document> listaDocEventos = new ArrayList<>();
		    for (Evento e : u.getLogs_eventos()) {
		        Document docEvento = new Document()
		            .append("id_evento", e.getId_evento()) 
		            .append("tag", e.getTag())
		            .append("mensaje", e.getMensaje())
		            .append("timestamp", e.getTimestamp());
		        listaDocEventos.add(docEvento);
		    }
		    return listaDocEventos;
		}
		
		
		public List<Usuario> read() { 
			List<Usuario> usuarios = new ArrayList<>();
			FindIterable<Document> documentos = coleccion.find();
			for (Document doc : documentos) {
			       Usuario u = documentToUser(doc);
			       usuarios.add(u);
			}
			return usuarios;
	}
		
		public Usuario documentToUser(Document doc) { 			
				Usuario u = new Usuario();
				u.setId(doc.getString("id"));
				u.setUsername(doc.getString("username"));
				u.setEmail(doc.getString("email"));
				u.setPlan_activo(PlanActivo.valueOf(doc.getString("plan_activo")));
				u.setDispositivo(doc.getString("dispositivo"));
				u.setPreferencias(documentToPreferencias(doc));
				u.setLogs_eventos(documentToEvento(doc));
				return u;
		}
		
		private Preferencias documentToPreferencias (Document doc) {
			Preferencias preferencias = null;
			Document docPreferencias = (Document) doc.get("preferencias");
			if (docPreferencias != null) {
			    preferencias = new Preferencias(
			        docPreferencias.getBoolean("tema_oscuro"),
			        docPreferencias.getString("idioma"),
			        docPreferencias.getBoolean("notificaciones_push"),
			        docPreferencias.getBoolean("limite_datos_moviles")
			    );
			}
			return preferencias;
		}
		
		private List<Evento> documentToEvento(Document doc) {
		    List<Evento> eventos = new ArrayList<>();
		    List<Document> docEventos = (List<Document>) doc.get("eventosLogs");
		    
		    if (docEventos != null) {
		        for (Document evento : docEventos) {
		            Evento eventoObj = new Evento(
		                evento.getString("id_evento"),
		                evento.getString("tag"),
		                evento.getString("mensaje"),
		                evento.getString("timestamp")
		            );
		            eventos.add(eventoObj); 
		        }
		    }
		    return eventos;
		}
		
		
		
		
		//métodos CRUD necesarios
		
		public void addUser (Usuario u) throws AppException { 
			if (!usuarios.contains(u)) { 
				Document user = userToDocument(u);
				coleccion.insertOne(user);
			}
			else {
				throw new AppException("El usuario ya existe en la lista, no puede ser añadido dos veces");
			}
		}
		
		public Usuario getUser(String id) throws AppException { 
			Usuario u = null;
			Document filtro = new Document("id", id);
			Document find = coleccion.findOneAndDelete(filtro);
			if (find == null) {
				throw new AppException("El id indicado no se encuentra en la lista");
			}
			else {
				u = documentToUser(find);
			}
			return u;
		} 
		
		public List<Usuario> orderBy () { 
			List<Usuario> usuariosOrderBy = new ArrayList<>();
			FindIterable<Document> findDocuments = coleccion.find().sort(Sorts.descending("plan_activo")).sort(Sorts.ascending("email"));
			
			for (Document d : findDocuments) {
				Usuario u = documentToUser(d);
				usuariosOrderBy.add(u);
			}
			return usuariosOrderBy;
		}
		
		
		//Otros métodos 
		
		public UpdateResult updateLanguage () { 
			Document filtro = new Document("preferencias.idioma", "ES");
			Document filtro2 = new Document("$set", 
				    new Document("preferencias.idioma", "ESP")
				);
			UpdateResult resultado = coleccion.updateMany(filtro, filtro2);
			return resultado;
		}
		
		public DeleteResult deleteAnual () { //sin probar
	        Document condicionPull = new Document("plan_activo", "ANUAL");
	        DeleteResult resultado = coleccion.deleteMany(condicionPull);
	        return resultado;
	    }
		
		public List<Usuario> getForCondition () { 
			List<Usuario> usuariosCondition = new ArrayList<>();
			Document condicionOR = new Document("$or", Arrays.asList( 
			        new Document("plan_activo", "MENSUAL"),
			        new Document("notificaciones_push", true)
			    ));
			Document condicionAND = new Document("$and", Arrays.asList( 
			        new Document("dispositivo", "android14"), 
			        condicionOR
			    ));
			FindIterable<Document> findDocuments = coleccion.find(condicionAND).sort(Sorts.ascending("email")).limit(3);
			for (Document d : findDocuments) {
				Usuario u = documentToUser(d);
				usuariosCondition.add(u);
			}
			
			return usuariosCondition;
		}
		
		public UpdateResult updatePlanActivo () { 
	        Document filtro = new Document("plan_activo", "VIP");
			Document filtro2 = new Document("$set", 
				    new Document("preferencias.limite_datos_moviles", true)
				);
	        UpdateResult resultado = coleccion.updateMany(filtro, filtro2);
	        return resultado;
		}
		
		public UpdateResult addEvent (String id,Evento e) { 
				Document filtro = new Document("id", id);
				Document docEvent = new Document()
				    .append("id_evento", e.getId_evento())
				    .append("tag", e.getTag())
				    .append("mensaje", e.getMensaje())
				    .append("timestamp", e.getTimestamp());
				UpdateResult resultado = coleccion.updateOne(filtro, Updates.push("eventosLogs", docEvent));
				return resultado;
			}

}
