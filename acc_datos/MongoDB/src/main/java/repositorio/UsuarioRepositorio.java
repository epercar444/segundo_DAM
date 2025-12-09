package repositorio;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.UpdateResult;

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
	   
		private Document userToDocument(Usuario u) { //devuelve un documento ya que nos hará falta para realizar las operaciones del crud
		       List<Document> listaL = librosToDocuments(u);
			
		       Document doc = new Document("id", u.getId())
		               .append("nombreUsuario", u.getNombreUsuario())
		               .append("email", u.getEmail())
		               .append("rol", u.getRol().toString())
		               .append("cuenta_verificada", u.getCuenta_verificada())
		               .append("suscripcion", suscripcionToDocument(u))
						.append("libros_biblioteca", listaL);

		
		       return doc;
			}
		
		
		private Document suscripcionToDocument (Usuario u) {
		       Document docSuscripcion = new Document() //definimos el documento(objeto) Suscripcion
		    		   .append("precio", u.getSuscripcion().getPrecio())
		    		   .append("pendiente_cobro", u.getSuscripcion().getPendiente_cobro())
		    		   .append("fecha_cobro", u.getSuscripcion().getFecha_cobro())
		    		   .append("tipo_plan", u.getSuscripcion().getTipoPlan().toString());
		       return docSuscripcion;
		}
		
		private List<Document> librosToDocuments(Usuario u) {
		    List<Document> listaDocLibros = new ArrayList<>();
		    for (Libro l : u.getLibros()) {
		        Document docLibro = new Document()
		            .append("ISBN", l.getISBN()) 
		            .append("titulo", l.getTitulo())
		            .append("autor", l.getAutor())
		            .append("num_paginas", l.getNum_paginas())
		            .append("genero", l.getGenero().toString())
		            .append("validado", l.getValidado())
		            .append("estado", l.getEstado().toString());
		        listaDocLibros.add(docLibro);
		    }
		    return listaDocLibros;
		}
		
		
		
		
		
		public void save(Usuario u) { //guardamos los documentos en la colección
	        Document doc = userToDocument(u);
	        coleccion.insertOne(doc);
	    }
		
		
		
		
		
		
		
		
			public List<Usuario> read() { //leemos los elementos de la coleccion y los guardamos en una lista
				List<Usuario> usuarios = new ArrayList<>();
				FindIterable<Document> documentos = coleccion.find();
				for (Document doc : documentos) {
				       Usuario u = documentToUser(doc);
				       usuarios.add(u);
				}
				return usuarios;
		}
			
			
			
			private Suscripcion documentToSuscripcion (Document doc) { //método para pasar documentos a objetos Suscripción
				Suscripcion suscripcion = null;
				Document docSuscripcion = (Document) doc.get("suscripcion");
				if (docSuscripcion != null) {
					Number precioNum = docSuscripcion.get("precio", Number.class);
		            double precio = (precioNum != null) ? precioNum.doubleValue() : 0.0; //guarda el 0.0 como 0, por eso no va con .getDouble()
				    suscripcion = new Suscripcion(
				        docSuscripcion.getBoolean("pendiente_cobro"),
				        docSuscripcion.getString("fecha_cobro"),
				        precio,
				        TipoPlan.valueOf(docSuscripcion.getString("tipo_plan"))
				    );
				}
				return suscripcion;
			}
			
			private List<Libro> documentToLibros(Document doc) {
			    List<Libro> libros = new ArrayList<>();
			    List<Document> docLibros = (List<Document>) doc.get("libros_biblioteca");
			    
			    if (docLibros != null) {
			        for (Document libro : docLibros) {
			            Libro libroObj = new Libro(
			                libro.getString("ISBN"),
			                libro.getString("titulo"),
			                libro.getString("autor"),
			                libro.getInteger("num_paginas"),
			                libro.getBoolean("validado"),
			                GeneroLibro.valueOf(libro.getString("genero")),
			                EstadoLibro.valueOf(libro.getString("estado"))
			            );
			            libros.add(libroObj); 
			        }
			    }
			    return libros;
			}
			
			public Usuario documentToUser(Document doc) { //pasamos un documento en un tipo usuario
				       List<Libro> listaL = documentToLibros(doc);
					
						Usuario u = new Usuario();
						u.setSuscripcion(documentToSuscripcion(doc));
						u.setLibros(listaL);
						u.setId(doc.getInteger("id", 0));
						u.setNombreUsuario(doc.getString("nombreUsuario"));
						u.setEmail(doc.getString("email"));
						u.setRol(RolUsuario.valueOf(doc.getString("rol")));
						u.setCuenta_verificada(doc.getBoolean("cuenta_verificada"));
						return u;
				}
			
			
			
			
			//CRUD
			
			
			public void addUser (Usuario u) throws AlreadyExistsException { //añadimos un usuario
				if (!usuarios.contains(u)) { //comprobamos si existe en la lista usuarios
					Document user = userToDocument(u); //lo convertimos a documento para poder añadirlo
					coleccion.insertOne(user);
				}
				else { //si ya existe saltará una excepción
					throw new AlreadyExistsException("El usuario ya existe en la lista, no puede ser añadido dos veces");
				}
			}
			
			public void deleteUser (Usuario u) throws AlreadyExistsException { //eliminamos usuario (mismos pasos anterior)
				if (usuarios.contains(u)) {
					Document user = userToDocument(u);
					coleccion.deleteOne(user);
				}
				else { //si no existe saltará la excepción
					throw new AlreadyExistsException("El usuario indicado no existe en la lista, por lo que no se puede eliminar");
				}
			}
			
			
			public Usuario getUser(int id) throws AlreadyExistsException {
				Usuario u = null;
				Document filtro = new Document("id", id);
				Document find = coleccion.findOneAndDelete(filtro);
				if (find == null) {
					throw new AlreadyExistsException("El id indicado no existe en la lista");
				}
				else {
					u = documentToUser(find);
				}
				return u;
			} 
			
			public void updateUser (int id,Usuario u) throws AlreadyExistsException {
				Document filtro = new Document("id", id);
				Document usuarioNuevo = userToDocument(u);
				UpdateResult result = coleccion.replaceOne(filtro, usuarioNuevo); 
				//definimos una variable tipo UpdateResult para poder lanzar una excepción en caso de que no se haya encontrado el filtro
				
				if (result.getMatchedCount() == 0) { //getMatchedCount recupera el número de documentos que cumplen nuestro filtro
					throw new AlreadyExistsException("El id indicado no existe en la lista, no se ha actualizado ningún usuario");
				}
			}
			
			
			
			//ORDENAR
			public List<Usuario> ordenarXId () {
				List<Usuario> ordenadosXIdes = new ArrayList<>();
				Document filtro = new Document();
				FindIterable<Document> find = coleccion.find(filtro).sort(Sorts.ascending("id")); //ordenamos los ides de manera ascendente
				for (Document d : find) {
					Usuario usuario = documentToUser(d);
					ordenadosXIdes.add(usuario);
				}
				return ordenadosXIdes;
			}
			
			//FILTRAR
			public List<Usuario> filtrarXrol (RolUsuario rol) { //filtrará por el rol que le pasemos por parametro
				List<Usuario> usuarios = new ArrayList<>();
				Document filtro = new Document("rol", rol); 
				FindIterable<Document> findDocuments = coleccion.find(filtro);
				
				for (Document d : findDocuments) {
					Usuario u = documentToUser(d);
					usuarios.add(u);
				}
				
				return usuarios;
				
			}
			
			
			
}
