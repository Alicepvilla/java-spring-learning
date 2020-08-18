package cl.crisgvera.repasocuatro.repository;

import cl.crisgvera.repasocuatro.model.relational.DetalleFaena;
import cl.crisgvera.repasocuatro.model.relational.embeddable.DetalleFaenaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFaenaRepository extends JpaRepository<DetalleFaena, DetalleFaenaId> {
}
