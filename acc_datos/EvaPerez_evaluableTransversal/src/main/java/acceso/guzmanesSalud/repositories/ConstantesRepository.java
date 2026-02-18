package acceso.guzmanesSalud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.guzmanesSalud.models.ConstantesVitales;

@Repository
public interface ConstantesRepository extends JpaRepository<ConstantesVitales, Long>{
    List<ConstantesVitales> findAll();
    ConstantesVitales findAutorById(long id);

}
