package myapp.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import myapp.models.Usuario;
import myapp.repositories.UsuarioRepository;

@Service
public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repoUsuario;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repoUsuario.findByUsuario(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsuario(),
                user.getClave(),
                Collections.emptyList()
        );
    }
}