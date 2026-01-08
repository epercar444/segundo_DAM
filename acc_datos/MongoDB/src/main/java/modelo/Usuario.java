package modelo;

import java.util.List;
import java.util.Objects;

import utils.RolUsuario;

public class Usuario implements Comparable<Usuario>{
	private String nombreUsuario,email;
	private int id;
	private boolean cuenta_verificada;
	private Suscripcion suscripcion;
	private List<Libro> libros_biblioteca;
	private RolUsuario rol;
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getCuenta_verificada() {
		return cuenta_verificada;
	}
	public void setCuenta_verificada(boolean cuenta_verificada) {
		this.cuenta_verificada = cuenta_verificada;
	}
	public Suscripcion getSuscripcion() {
		return suscripcion;
	}
	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}
	public List<Libro> getLibros() {
		return libros_biblioteca;
	}
	public void setLibros(List<Libro> libros) {
		this.libros_biblioteca = libros;
	}
	public RolUsuario getRol() {
		return rol;
	}
	public void setRol(RolUsuario rol) {
		this.rol = rol;
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
		Usuario other = (Usuario) obj;
		return id == other.id;
	}
	public Usuario(String nombreUsuario, String email, int id, boolean cuenta_verificada, Suscripcion suscripcion,
			List<Libro> libros, RolUsuario rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.id = id;
		this.cuenta_verificada = cuenta_verificada;
		this.suscripcion = suscripcion;
		this.libros_biblioteca = libros;
		this.rol = rol;
	}
	public Usuario() {
		super();
	}
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", email=" + email + ", id=" + id + ", cuenta_verificada="
				+ cuenta_verificada + ", suscripcion=" + suscripcion + ", libros=" + libros_biblioteca + ", rol=" + rol + "]";
	}
	
	@Override
	public int compareTo(Usuario o) {
		return o.getNombreUsuario().compareTo(this.nombreUsuario);
	}
	
}
