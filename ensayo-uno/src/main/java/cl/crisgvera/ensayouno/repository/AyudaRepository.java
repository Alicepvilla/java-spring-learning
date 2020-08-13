package cl.crisgvera.ensayouno.repository;

import cl.crisgvera.ensayouno.model.Ayuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AyudaRepository extends JpaRepository<Ayuda, Long> {
}
