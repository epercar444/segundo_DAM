package repositorio;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import modelo.Libro;
import modelo.Suscripcion;
import modelo.Usuario;
import utils.AlreadyExistsException;
import utils.EstadoLibro;
import utils.GeneroLibro;
import utils.RolUsuario;
import utils.TipoPlan;

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
	   
		private Document UserToDocument(Usuario u) { //devuelve un documento ya que nos hará falta para realizar las operaciones del crud
		       Document docSuscripcion = new Document() //definimos el documento(objeto) Suscripcion
		    		   .append("precio", u.getSuscripcion().getPrecio())
		    		   .append("pendiente_cobro", u.getSuscripcion().getPendiente_cobro())
		    		   .append("fecha_cobro", u.getSuscripcion().getFecha_cobro())
		    		   .append("tipo_plan", u.getSuscripcion().getTipoPlan());
		       
		       List<Document> listaL = new ArrayList<>();
		       for (Libro l : u.getLibros()) {
			       Document docLibro = new Document() //definimos los documentos (lista de objetos) Libros_biblioteca
			    		   .append("ISBN",l.getISBN()) 
			    		   .append("titulo", l.getTitulo())
			    		   .append("autor", l.getAutor())
			    		   .append("num_paginas", l.getNum_paginas())
			    		   .append("genero", l.getGenero())
			    		   .append("validado", l.getValidado())
			    		   .append("estado", l.getEstado());
			       listaL.add(docLibro);
		       }
		       
		       Document doc = new Document("id", u.getId())
		               .append("nombreUsuario", u.getNombreUsuario())
		               .append("email", u.getEmail())
		               .append("rol", u.getRol())
		               .append("cuenta_verificada", u.getCuenta_verificada())
		               .append("suscripcion", docSuscripcion)
						.append("libros_biblioteca", listaL);

		
		       return doc;
			}
		public void save(Usuario u) { //guardamos los documentos en la colección
	        Document doc = UserToDocument(u);
	        coleccion.insertOne(doc);
	    }
			public List<Usuario> read() { //leemos los elementos de la coleccion y los guardamos en una lista
				List<Usuario> usuarios = new ArrayList<>();
				FindIterable<Document> documentos = coleccion.find();
				for (Document doc : documentos) {
					Usuario u = new Usuario();
					Document docSuscripcion = (Document) doc.get("suscripcion");
					if (docSuscripcion != null) {

						Number precioNum = docSuscripcion.get("precio", Number.class);
			            double precio = (precioNum != null) ? precioNum.doubleValue() : 0.0; //guarda el 0.0 como 0, por eso no va con .getDouble()
			            
					    Suscripcion suscripcion = new Suscripcion(
					        docSuscripcion.getBoolean("pendiente_cobro"),
					        docSuscripcion.getString("fecha_cobro"),
					        precio,
					        TipoPlan.valueOf(docSuscripcion.getString("tipo_plan"))
					    );
					    u.setSuscripcion(suscripcion);
					}
					List<Document> docLibro = (List<Document>) doc.get("libros_biblioteca");
					List<Libro> librosSet = new ArrayList<>();
					if (docLibro!=null) {
						for (Document libro : docLibro) {
				            Libro libroObj = new Libro(
				                libro.getString("ISBN"),
				                libro.getString("titulo"),
				                libro.getString("autor"),
				                libro.getInteger("num_paginas"),
				                libro.getBoolean("validado"),
				                GeneroLibro.valueOf(libro.getString("genero")),
				                EstadoLibro.valueOf(libro.getString("estado"))
				            );
				            librosSet.add(libroObj);
				           
					}
					u.setLibros(librosSet);
					
					
					u.setId(doc.getInteger("id", 0));
					u.setNombreUsuario(doc.getString("nombreUsuario"));
					u.setEmail(doc.getString("email"));
					u.setRol(RolUsuario.valueOf(doc.getString("rol")));
					u.setCuenta_verificada(doc.getBoolean("cuenta_verificada"));
					usuarios.add(u);
				}
			}
				return usuarios;
		}
			
			public void addUser (Usuario u) throws AlreadyExistsException { //añadimos un usuario
				if (!usuarios.contains(u)) { //comprobamos si existe en la lista usuarios
					Document user = UserToDocument(u); //lo convertimos a documento para poder añadirlo
					coleccion.insertOne(user);
				}
				else { //si ya existe saltará una excepción
					throw new AlreadyExistsException("El usuario ya existe en la lista, no puede ser añadido dos veces");
				}
			}
			
			public void deleteUser (Usuario u) throws AlreadyExistsException { //eliminamos usuario (mismos pasos anterior)
				if (usuarios.contains(u)) {
					Document user = UserToDocument(u);
					coleccion.deleteOne(user);
				}
				else { //si no existe saltará la excepción
					throw new AlreadyExistsException("El usuario indicado no existe en la lista, por lo que no se puede eliminar");
				}
			}
			
			
			
			
			
			//PENDIENTE REVISIÓN
			public Usuario getUser(int id) throws AlreadyExistsException {
				Usuario u = null;
				for (Usuario u1 : usuarios) {
					if (u1.getId() == id) {
						u = u1;
					}
				}
				if (u.equals(null)) {
					throw new AlreadyExistsException("El usuario no existe");
				}
				
				
				Document user = UserToDocument(u);
				FindIterable<Document> usuario = coleccion.find(user);
				MongoCursor<Document> cursor = usuario.iterator();
				while (cursor.hasNext()) {
				    Document doc = cursor.next();
				    u = new Usuario();
					Document docSuscripcion = (Document) doc.get("suscripcion");
					if (docSuscripcion != null) {

						Number precioNum = docSuscripcion.get("precio", Number.class);
			            double precio = (precioNum != null) ? precioNum.doubleValue() : 0.0; //guarda el 0.0 como 0, por eso no va con .getDouble()
			            
					    Suscripcion suscripcion = new Suscripcion(
					        docSuscripcion.getBoolean("pendiente_cobro"),
					        docSuscripcion.getString("fecha_cobro"),
					        precio,
					        TipoPlan.valueOf(docSuscripcion.getString("tipo_plan"))
					    );
					    u.setSuscripcion(suscripcion);
					}
					List<Document> docLibro = (List<Document>) doc.get("libros_biblioteca");
					List<Libro> librosSet = new ArrayList<>();
					if (docLibro!=null) {
						for (Document libro : docLibro) {
				            Libro libroObj = new Libro(
				                libro.getString("ISBN"),
				                libro.getString("titulo"),
				                libro.getString("autor"),
				                libro.getInteger("num_paginas"),
				                libro.getBoolean("validado"),
				                GeneroLibro.valueOf(libro.getString("genero")),
				                EstadoLibro.valueOf(libro.getString("estado"))
				            );
				            librosSet.add(libroObj);
				           
					}
					u.setLibros(librosSet);
					
					
					u.setId(doc.getInteger("id", 0));
					u.setNombreUsuario(doc.getString("nombreUsuario"));
					u.setEmail(doc.getString("email"));
					u.setRol(RolUsuario.valueOf(doc.getString("rol")));
					u.setCuenta_verificada(doc.getBoolean("cuenta_verificada"));
			}
	   
				}
				return u;
			}
}
