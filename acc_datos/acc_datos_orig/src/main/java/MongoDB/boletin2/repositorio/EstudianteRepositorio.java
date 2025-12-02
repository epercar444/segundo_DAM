package MongoDB.boletin2.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import MongoDB.boletin2.modelo.Address;
import MongoDB.boletin2.modelo.Estudiante;
import MongoDB.boletin2.modelo.Scores;
import MongoDB.boletin2.utils.AlreadyExistsException;

public class EstudianteRepositorio {
	  private static final String NOMBRE_COLECCION = "estudiantes";
	  private final MongoCollection<Document> coleccion;
	  private List<Estudiante> estudiantes;

	   public EstudianteRepositorio(MongoDatabase db) {
	       this.coleccion = db.getCollection(NOMBRE_COLECCION);
	       this.estudiantes = this.read();
	   }
	   

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}


	   public void setEstudiantes(List<Estudiante> estudiantes) {
		   this.estudiantes = estudiantes;
	   }


	public void save(Estudiante e) {
	       Document docAddress = new Document()
	    		   .append("city", e.getDireccion().getCity())
	    		   .append("zip", e.getDireccion().getZip())
	    		   .append("street", e.getDireccion().getStreet())
	    		   .append("number", e.getDireccion().getNumber());
	       
	       List<Document> listaS = new ArrayList<>();
	       for (Scores s : e.getNotas()) {
		       Document docScores = new Document()
		    		   .append("score",s.getScore()) 
		    		   .append("type", s.getType());
		       listaS.add(docScores);
	       }
	       
	       Document doc = new Document("id", e.getId())
	               .append("name", e.getName())
	               .append("notaMedia", e.getNotaMedia())
	               .append("aficiones", e.getAficiones())
	               .append("address", docAddress)
					.append("scores", listaS);

	
	       coleccion.insertOne(doc);
		}
		public List<Estudiante> read() {
			List<Estudiante> estudiantes = new ArrayList<>();
			FindIterable<Document> documentos = coleccion.find();
			for (Document doc : documentos) {
				Estudiante e = new Estudiante();
				Document addressDoc = (Document) doc.get("address");
				if (addressDoc != null) {

				    Address address = new Address(
				        addressDoc.getString("city"),
				        addressDoc.getString("street"),
				        addressDoc.getInteger("zip", 0),
				        addressDoc.getInteger("number", 0)
				    );
				    e.setDireccion(address);
				}
				List<Document> scoresDoc = (List<Document>) doc.get("scores");
				List<Scores> scoresSet = new ArrayList<>();
				if (scoresDoc!=null) {
					for (Document score : scoresDoc) {
			            Object val = score.get("score");
			            double scoreValue = val != null ? ((Number) val).doubleValue() : 0D;

			            Scores scoresObj = new Scores(
			                score.getString("type"),
			                scoreValue
			            );
			            scoresSet.add(scoresObj);
			           
				}
					e.setNotas(scoresSet);
				
				
				
				e.setId(doc.getInteger("id", 0));
				e.setName(doc.getString("name"));
				Object val = doc.get("notaMedia");
				e.setNotaMedia(val != null ? ((Number) val).doubleValue() : 0D);
				List<String> aficiones = doc.getList("aficiones", String.class);
				e.setAficiones(aficiones != null ? aficiones : new ArrayList<>());
				estudiantes.add(e);
			}
		}
			return estudiantes;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		//CRUD
		
		public void addEstudiante (Estudiante e) throws AlreadyExistsException {
			if (estudiantes.contains(e)) {
				throw new AlreadyExistsException("Este estudiante ya existe en la lista");
			}
			else {
				estudiantes.add(e);
			}
		}
		
		
		public void deleteEstudiante (int id) throws AlreadyExistsException {
			Estudiante e = getEstudiante(id);
			if (!e.equals(null)) {
				estudiantes.remove(e);
			}
		}
		
		
		public Estudiante getEstudiante (int id) throws AlreadyExistsException {
			int i = 0;
			Estudiante e = null;
			boolean encontrado = false;
			while (!encontrado && i < estudiantes.size()) {
				if (estudiantes.get(i).equals(id)) {
					encontrado = true;
					e = estudiantes.get(i);
				}
				else {
					i++;
				}
				
			}
			if (e.equals(null)) {
				throw new AlreadyExistsException("No se encuentra el estudiante con el id indicado");
			}
			return e;
		}
		
		public void updateEstudiante (int id,Estudiante e1) throws AlreadyExistsException {
			Estudiante e = getEstudiante(id);
			if (!e.equals(e)) {
				estudiantes.remove(e);
				estudiantes.add(e1);
			}
		}
}
