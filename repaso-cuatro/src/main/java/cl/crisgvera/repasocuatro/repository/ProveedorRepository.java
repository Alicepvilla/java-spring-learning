package cl.crisgvera.repasocuatro.repository;

import cl.crisgvera.repasocuatro.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, String> {
}
