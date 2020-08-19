package cl.crisgvera.ensayodos.repository;

import cl.crisgvera.ensayodos.model.DetalleFactura;
import cl.crisgvera.ensayodos.model.relation.ProductoFacturaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, ProductoFacturaId> {
}
