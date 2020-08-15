package cl.crisgvera.repasocuatro.service;

import cl.crisgvera.repasocuatro.model.Proveedor;
import cl.crisgvera.repasocuatro.repository.ProveedorRepository;
import cl.crisgvera.repasocuatro.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProveedorService implements DAO<Proveedor, String> {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Proveedor getOne(String rut) {
        return Optional.ofNullable(proveedorRepository.getOne(rut))
                .orElse(null);
    }

    @Override
    public Collection<Proveedor> getAll() {
        return proveedorRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor update(Proveedor proveedor) {
        return null;
    }

    @Override
    public void delete(Proveedor proveedor) {

    }
}
