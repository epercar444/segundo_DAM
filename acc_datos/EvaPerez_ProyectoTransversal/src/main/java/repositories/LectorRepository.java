package repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Lector;
import models.Libro;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long>{
    List<Lector> findAll();
    Set<Lector> findByUsername(String username);
    Lector findLectorById(long id);
}
