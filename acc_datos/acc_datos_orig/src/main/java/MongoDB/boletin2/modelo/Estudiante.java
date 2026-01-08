package MongoDB.boletin2.modelo;

import java.util.List;
import java.util.Objects;

public class Estudiante {
	   private int id;
	   private String name;
	   private double notaMedia;
	   private List<String> aficiones;
	   private List<Scores> notas;
	   private Address direccion;
	   public int getId() {
		   return id;
	   }
	   public void setId(int id) {
		   this.id = id;
	   }
	   public String getName() {
		   return name;
	   }
	   public void setName(String name) {
		   this.name = name;
	   }
	   public double getNotaMedia() {
		   return notaMedia;
	   }
	   public void setNotaMedia(double d) {
		   this.notaMedia = d;
	   }
	   public List<String> getAficiones() {
		   return aficiones;
	   }
	   public void setAficiones(List<String> aficiones) {
		   this.aficiones = aficiones;
	   }
	   public List<Scores> getNotas() {
		   return notas;
	   }
	   public void setNotas(List<Scores> notas) {
		   this.notas = notas;
	   }
	   public Address getDireccion() {
		   return direccion;
	   }
	   public void setDireccion(Address direccion) {
		   this.direccion = direccion;
	   }
	   public Estudiante(int id, String name, double notaMedia, List<String> aficiones, List<Scores> notas,
			Address direccion) {
		super();
		this.id = id;
		this.name = name;
		this.notaMedia = notaMedia;
		this.aficiones = aficiones;
		this.notas = notas;
		this.direccion = direccion;
	   }
	   public Estudiante() {
		super();
	   }
	   @Override
	   public String toString() {
		return "Estudiante [id=" + id + ", name=" + name + ", notaMedia=" + notaMedia + ", aficiones=" + aficiones
				+ ", notas=" + notas + ", direccion=" + direccion + "]";
	   }
	   @Override
	   public int hashCode() {
		return Objects.hash(id);
	   }
	   @Override
	   public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return id == other.id;
	   }
}
