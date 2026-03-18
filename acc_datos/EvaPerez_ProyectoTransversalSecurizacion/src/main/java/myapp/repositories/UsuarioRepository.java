package myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import myapp.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario); 
    boolean existsByUsuario(String usuario);
}