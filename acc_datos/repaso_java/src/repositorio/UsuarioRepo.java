package repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import modelo.Usuario;

public class UsuarioRepo {
	List<Usuario> usuarios;
	
	
	public UsuarioRepo() {
		super();
		this.usuarios = new ArrayList<>();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	@Override
	public String toString() {
		return "usuarioRepo [usuarios=" + usuarios + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuarios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioRepo other = (UsuarioRepo) obj;
		return Objects.equals(usuarios, other.usuarios);
	}

	
	
	
	public void addUsuario (Usuario u) {
		this.usuarios.add(u);
	}
	
	public void borrarUsuario (Usuario u) {
		this.usuarios.remove(u);
	}
	
	public Usuario devuelveUsuario (Usuario u) {
		Usuario f = null;
		if (this.usuarios.contains(u)){
			f = u;
		}
		return f;
	}
}