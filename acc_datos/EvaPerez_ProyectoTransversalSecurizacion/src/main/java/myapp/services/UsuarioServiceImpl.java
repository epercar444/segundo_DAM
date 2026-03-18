package myapp.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import myapp.models.Usuario;
import myapp.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
            usuario.getUsuario(),
            usuario.getClave(),
            new ArrayList<>()
        );
    }

    @Override
    public boolean existsByUsuario(String usuario) {
        return usuarioRepository.existsByUsuario(usuario);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}