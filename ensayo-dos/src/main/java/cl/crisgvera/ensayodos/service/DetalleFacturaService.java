package cl.crisgvera.ensayodos.service;

import cl.crisgvera.ensayodos.model.DetalleFactura;
import cl.crisgvera.ensayodos.model.relation.ProductoFacturaId;
import cl.crisgvera.ensayodos.service.util.DAO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DetalleFacturaService implements DAO<DetalleFactura, ProductoFacturaId> {
    @Override
    public DetalleFactura getOne(ProductoFacturaId productoFacturaId) {
        return null;
    }

    @Override
    public Collection<DetalleFactura> getAll() {
        return null;
    }

    @Override
    public DetalleFactura save(DetalleFactura detalleFactura) {
        return null;
    }

    @Override
    public DetalleFactura update(DetalleFactura detalleFactura) {
        return null;
    }

    @Override
    public void delete(DetalleFactura detalleFactura) {

    }
}
