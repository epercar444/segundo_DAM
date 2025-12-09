package MongoDB.simulacion.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import MongoDB.simulacion.modelo.Coordenada;
import MongoDB.simulacion.modelo.Habitacion;
import MongoDB.simulacion.modelo.Hotel;
import MongoDB.simulacion.modelo.Ubicacion;
import MongoDB.simulacion.utils.TipoHabitacion;
import MongoDB.simulacion.utils.AlreadyExistsException;

public class HotelRepositorio {
	  private static final String NOMBRE_COLECCION = "usuarios";
	  private final MongoCollection<Document> coleccion;
	  private List<Hotel> hoteles;
	  
	  
	  public HotelRepositorio(MongoDatabase db) {
		super();
		this.coleccion = db.getCollection(NOMBRE_COLECCION);;
		this.hoteles = this.read();
	  }
	  
	  public List<Hotel> getHoteles() {
		  return hoteles;
	  }
	  public void setHoteles(List<Hotel> hoteles) {
		  this.hoteles = hoteles;
	  }
	  
	  private Document hotelToDocument (Hotel h) {
	       Document docHotel = new Document() 
	    		   .append("id", h.getId())
	    		   .append("nombre", h.getNombre())
	    		   .append("fechaApertura", h.getFechaApertura())
	    		   .append("estrellas", h.getEstrellas())
	    		   .append("admiteMascotas", h.isAdmiteMascotas())
	    		   .append("ubicacion", ubicacionToDocument(h))
	    		   .append("habitaciones", habitacionesToDocument(h));
	       return docHotel;
	  }
	  
	  private List<Document> habitacionesToDocument (Hotel h) {
		    List<Document> listaDocHabitacion = new ArrayList<>();
		    for (Habitacion hab : h.getHabitaciones()) {
		        Document docHabitacion = new Document()
		            .append("tipo", hab.getTipo()) 
		            .append("capacidad", hab.getCapacidad())
		            .append("disponible", hab.getDisponible())
		            .append("precio", hab.getPrecio());
		        listaDocHabitacion.add(docHabitacion);
		    }
		    return listaDocHabitacion;
		}
	  
	  
	  private Document coordenadaToDocument (Hotel h) {
	       Document docCoordenada = new Document()
		   .append("lat", h.getUbicacion().getCoordenadas().getLat())
		   .append("lon", h.getUbicacion().getCoordenadas().getLon());
	       return docCoordenada;
	  }
	  
	  private Document ubicacionToDocument (Hotel h) {
	       Document docUbicacion = new Document() 
	    		   .append("calle", h.getUbicacion().getCalle())
	    		   .append("codigoPostal", h.getUbicacion().getCodigoPostal())
	    		   .append("numero", h.getUbicacion().getNumero())
	    		   .append("coordenadas", coordenadaToDocument(h));
	       return docUbicacion;
	  }
	  
	  
		public void save(Hotel h) {
	        Document doc = hotelToDocument(h);
	        coleccion.insertOne(doc);
	    }
		
		
		public List<Hotel> read () {
			List<Hotel> hoteles = new ArrayList<>();
			FindIterable<Document> documentos = coleccion.find();
			for (Document doc : documentos) {
				Hotel h = documentToHotel(doc);
				hoteles.add(h);
			}
			return hoteles;
		}
		
		private Hotel documentToHotel (Document doc) {
				Hotel h = new Hotel();
				h.setUbicacion(documentToUbicacion(doc));;
				h.setHabitaciones(documentToHabitacion(doc));;
				h.setId(doc.getString("id"));
				h.setNombre(doc.getString("nombre"));
				h.setFechaApertura(doc.getString("fechaApertura"));
				h.setAdmiteMascotas(doc.getBoolean("admiteMascotas"));
				return h;
		}
		
		private Coordenada documentToCoordenada (Document doc) { //método para pasar documentos a objetos Suscripción
			Coordenada coordenada = null;
			Document docCoordenada = (Document) doc.get("coordenadas");
			if (docCoordenada != null) {
				Number latNum = docCoordenada.get("lat", Number.class);
	            double lat = (latNum != null) ? latNum.doubleValue() : 0.0; 
	            
				Number lonNum = docCoordenada.get("lon", Number.class);
	            double lon = (lonNum != null) ? lonNum.doubleValue() : 0.0; 
	            
			    coordenada = new Coordenada(
			        lat,
			        lon
			    );
			}
			return coordenada;
		}
		
		private Ubicacion documentToUbicacion (Document doc) {
			Ubicacion ubicacion = null;
			Document docUbicacion = (Document) doc.get("ubicacion");
			Coordenada coordenada = documentToCoordenada(docUbicacion); //o doc??
			
			if (docUbicacion != null) {
			    ubicacion = new Ubicacion(
			        docUbicacion.getString("calle"),
			        docUbicacion.getString("codigoPostal"),
			        docUbicacion.getInteger("numero"),
			        coordenada
			    );
			}
			return ubicacion;
		}
		
		private List<Habitacion> documentToHabitacion(Document doc) {
		    List<Habitacion> habitaciones = new ArrayList<>();
		    List<Document> docHabitaciones = (List<Document>) doc.get("habitaciones"); 
		    
		    if (docHabitaciones != null) {
		        for (Document habitacion : docHabitaciones) {
					Number precioNum = habitacion.get("precio", Number.class);
		            double precio = (precioNum != null) ? precioNum.doubleValue() : 0.0;
		            
		            
		            Habitacion habitacionObj = new Habitacion(
			            TipoHabitacion.valueOf(habitacion.getString("tipo")),
		                habitacion.getInteger("capacidad"),
		                habitacion.getBoolean("disponible"),
		                precio		                
		            );
		            habitaciones.add(habitacionObj); 
		        }
		    }
		    return habitaciones;
		}
		
		
		
		//CRUD
		public void addHotel (Hotel h) throws AlreadyExistsException{ 
			if (!hoteles.contains(h)) { 
				Document hotel = hotelToDocument(h); 
				coleccion.insertOne(hotel);
			}
			else { 
				throw new AlreadyExistsException("El hotel ya existe en la lista, no puede ser añadido dos veces");
			}
		}
		
		public void deleteHotel (Hotel h) throws AlreadyExistsException { 
			if (hoteles.contains(h)) {
				Document hotel = hotelToDocument(h); 
				coleccion.deleteOne(hotel);
			}
			else { 
				throw new AlreadyExistsException("El hotel indicado no existe en la lista, por lo que no se puede eliminar");
			}
		}
		
		
		public Hotel getHotel(int id) throws AlreadyExistsException {
			Hotel h = null;
			Document filtro = new Document("id", id);
			Document find = coleccion.findOneAndDelete(filtro);
			if (find == null) {
				throw new AlreadyExistsException("El id indicado no existe en la lista");
			}
			else {
				h = documentToHotel(find);
			}
			return h;
		} 
		
		public void updateUser (int id,Hotel h) throws AlreadyExistsException {
			Document filtro = new Document("id", id);
			Document usuarioNuevo = hotelToDocument(h);
			UpdateResult result = coleccion.replaceOne(filtro, usuarioNuevo); 
			
			if (result.getMatchedCount() == 0) {
				throw new AlreadyExistsException("El id indicado no existe en la lista, no se ha actualizado ningún hotel");
			}
		}
	  
	  
	  
	  
	  
	  
	  
}

