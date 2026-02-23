package myapp.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myapp.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
    List<Autor> findAll();
    Autor findAutorById(long id);
}
