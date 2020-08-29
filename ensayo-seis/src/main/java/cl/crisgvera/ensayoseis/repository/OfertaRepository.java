package cl.crisgvera.ensayoseis.repository;

import cl.crisgvera.ensayoseis.model.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {
}
