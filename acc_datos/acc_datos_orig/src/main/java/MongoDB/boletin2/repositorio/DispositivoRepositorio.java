package MongoDB.boletin2.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import MongoDB.boletin2.modelo.Dispositivo;
import MongoDB.boletin2.modelo.Especificacion;
import MongoDB.boletin2.modelo.Valoracion;


public class DispositivoRepositorio {
	  private static final String NOMBRE_COLECCION = "dispositivos";
	  private final MongoCollection<Document> coleccion;
	  private List<Dispositivo> dispositivos;

	   public DispositivoRepositorio(MongoDatabase db) {
	       this.coleccion = db.getCollection(NOMBRE_COLECCION);
	       this.dispositivos = this.read();
	   }
	   

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}


	   public void set(List<Dispositivo> dispositivos) {
		   this.dispositivos = dispositivos;
	   }


	   public void save(Dispositivo d) {
			Document docEspecificacion = new Document()
			.append("wifi", d.getEspecificaciones().getWifi())
			.append("cobertura", d.getEspecificaciones().getCobertura())
			.append("unidades", d.getEspecificaciones().getUnidades());
			
			List<Document> listaV = new ArrayList<>();
			for (Valoracion v : d.getValoraciones()) {
				Document docValoraciones = new Document()
				.append("usuario",v.getUsuario())
				.append("comentario", v.getComentario())
				.append("puntuacion",v.getPuntuacion());
				listaV.add(docValoraciones);
			}
			
			Document doc = new Document("id", d.getId())
			.append("stock", d.getStock())
			.append("precio", d.getPrecio())
			.append("nombre", d.getNombre())
			.append("categoria", d.getCategoria())
						.append("especificaciones", docEspecificacion)
						.append("valoraciones", listaV);

			
			coleccion.insertOne(doc);
				if (!this.dispositivos.contains(d)) {
					this.dispositivos.add(d);
				}
			}
		public List<Dispositivo> read() {
			List<Dispositivo> dispositivos = new ArrayList<>();
			FindIterable<Document> documentos = coleccion.find();
			for (Document doc : documentos) {
				Dispositivo d = new Dispositivo();
				Document docEspecificacion = (Document) doc.get("especificaciones");
				if (docEspecificacion != null) {

				    Especificacion especificacion = new Especificacion(
				        docEspecificacion.getString("wifi"),
				        docEspecificacion.getString("cobertura"),
				        docEspecificacion.getInteger("unidades", 0)
				    );
				    d.setEspecificaciones(especificacion);
				}
				List<Document> docValoraciones = (List<Document>) doc.get("valoraciones");
				List<Valoracion> scoresSet = new ArrayList<>();
				if (docValoraciones!=null) {
					for (Document valoracion : docValoraciones) {
			            Object val = valoracion.get("puntuacion");
			            double valoracionVal = val != null ? ((Number) val).doubleValue() : 0D;

			            Valoracion ValoracionObj = new Valoracion(
			                valoracion.getString("usuario"),
			                valoracion.getString("comentario"),
			                valoracionVal
			            );
			            scoresSet.add(ValoracionObj);
			           
				}
					d.setValoraciones(scoresSet);
				
				
				
				d.setId(doc.getInteger("id", 0));
				d.setStock(doc.getInteger("stock"));
				d.setNombre(doc.getString("nombre"));
				d.setCategoria(doc.getString("categoria"));
				Object val = doc.get("precio");
				d.setPrecio(val != null ? ((Number) val).doubleValue() : 0D);

				dispositivos.add(d);
			}
		}
			return dispositivos;
	}
		
		
		
		
		public void addDispositivo (Dispositivo d) {
			if (!dispositivos.contains(d)) {
				dispositivos.add(d);
			}
		}
}
