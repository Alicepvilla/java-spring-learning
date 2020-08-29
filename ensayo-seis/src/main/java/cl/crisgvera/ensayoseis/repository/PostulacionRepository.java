package cl.crisgvera.ensayoseis.repository;

import cl.crisgvera.ensayoseis.model.Postulacion;
import cl.crisgvera.ensayoseis.model.relation.PostulacionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulacionRepository extends JpaRepository<Postulacion, PostulacionId> {
}
