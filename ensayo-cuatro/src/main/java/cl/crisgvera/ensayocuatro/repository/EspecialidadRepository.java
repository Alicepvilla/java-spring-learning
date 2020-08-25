package cl.crisgvera.ensayocuatro.repository;

import cl.crisgvera.ensayocuatro.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
}
