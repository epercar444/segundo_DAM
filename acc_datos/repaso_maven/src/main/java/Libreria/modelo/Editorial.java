package Libreria.modelo;

import java.util.Objects;

public class Editorial {

	private String nombre,dirección,CIF,web,email;

	public Editorial(String nombre, String dirección, String cIF, String web, String email) {
		super();
		this.nombre = nombre;
		this.dirección = dirección;
		CIF = cIF;
		this.web = web;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CIF);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editorial other = (Editorial) obj;
		return Objects.equals(CIF, other.CIF);
	}

	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", dirección=" + dirección + ", CIF=" + CIF + ", web=" + web + ", email="
				+ email + "]";
	}
}
