package myapp.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myapp.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{
    List<Libro> findAll();
    Libro findLibroById(long id);
}
