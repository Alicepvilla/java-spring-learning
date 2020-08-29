package cl.crisgvera.ensayoseis.repository;

import cl.crisgvera.ensayoseis.model.Reclutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReclutadorRepository extends JpaRepository<Reclutador, Long> {
    Optional<Reclutador> findByRut(String rut);
}
