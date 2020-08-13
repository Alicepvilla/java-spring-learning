package cl.simulacion.sim.repository;

import cl.simulacion.sim.model.Ayuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AyudaRepository extends JpaRepository<Ayuda, Long> {
}
