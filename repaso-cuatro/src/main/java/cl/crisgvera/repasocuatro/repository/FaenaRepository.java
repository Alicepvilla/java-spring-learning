package cl.crisgvera.repasocuatro.repository;

import cl.crisgvera.repasocuatro.model.Faena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaenaRepository extends JpaRepository<Faena, Long> {
}
