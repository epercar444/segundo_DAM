package myapp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import myapp.models.Usuario;

public interface UsuarioService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    boolean existsByUsuario(String usuario);
    void saveUsuario(Usuario u);
}