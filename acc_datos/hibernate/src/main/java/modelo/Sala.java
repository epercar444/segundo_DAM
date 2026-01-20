package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
	@Entity
	@Table(name = "sala")
	public class Sala {
		// Este campo es la clave primaria
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int idSala; 
		private int capacidad;
		private String nombre;
		
		
		@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
		private List<Reunion> reuniones;
		
		
		public List<Reunion> getReuniones() {
			return reuniones;
		}
		public void setReuniones(List<Reunion> reuniones) {
			this.reuniones = reuniones;
		}
		public int getIdSala() {
			return idSala;
		}
		public void setIdSala(int idSala) {
			this.idSala = idSala;
		}
		public int getCapacidad() {
			return capacidad;
		}
		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Sala() {
			super();
		}
		
		public Sala(int capacidad, String nombre) {
			super();
			this.capacidad = capacidad;
			this.nombre = nombre;
			this.reuniones = new ArrayList<>();
		}
		@Override
		public String toString() {
			return "Sala [idSala=" + idSala + ", capacidad=" + capacidad + ", nombre=" + nombre + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(idSala);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Sala other = (Sala) obj;
			return idSala == other.idSala;
		}
		
		public void anadirReunion (Reunion r) {
			reuniones.add(r);
		}
		
		
		
		
		
		
		
}
