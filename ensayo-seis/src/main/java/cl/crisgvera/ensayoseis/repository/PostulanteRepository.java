package cl.crisgvera.ensayoseis.repository;

import cl.crisgvera.ensayoseis.model.Postulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostulanteRepository extends JpaRepository<Postulante, Long> {
    Optional<Postulante> findByRut(String rut);
}
