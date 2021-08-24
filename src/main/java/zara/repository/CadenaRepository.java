package zara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zara.model.cadena.Cadena;

@Repository
public interface CadenaRepository extends JpaRepository<Cadena, Integer> {
}
