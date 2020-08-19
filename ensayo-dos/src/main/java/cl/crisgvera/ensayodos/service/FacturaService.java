package cl.crisgvera.ensayodos.service;

import cl.crisgvera.ensayodos.model.Factura;
import cl.crisgvera.ensayodos.repository.FacturaRepository;
import cl.crisgvera.ensayodos.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FacturaService implements DAO<Factura, Long> {
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Factura getOne(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public List<Integer> getTotalValues(Factura factura) {
        List<Integer> totalValue = new ArrayList<>();
        Integer subtotal = 0;
        for (var detalleFactura : factura.getDetalleFacturas()) {
            int value = detalleFactura.getProducto().getValue();
            int quantity = detalleFactura.getQuantity();
            subtotal += value * quantity;
        }
        Integer tax = Math.toIntExact(Math.round(subtotal * 0.19));
        totalValue.add(subtotal);
        totalValue.add(tax);
        totalValue.add(subtotal + tax);
        return totalValue;
    }

    @Override
    public Collection<Factura> getAll() {
        return null;
    }

    @Override
    public Factura save(Factura factura) {
        return null;
    }

    @Override
    public Factura update(Factura factura) {
        return null;
    }

    @Override
    public void delete(Factura factura) {

    }
}
