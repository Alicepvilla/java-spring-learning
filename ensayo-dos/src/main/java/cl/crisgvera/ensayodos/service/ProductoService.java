package cl.crisgvera.ensayodos.service;

import cl.crisgvera.ensayodos.model.Producto;
import cl.crisgvera.ensayodos.repository.ProductoRepository;
import cl.crisgvera.ensayodos.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductoService implements DAO<Producto, Long> {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto getOne(Long aLong) {
        return null;
    }

    @Override
    public Collection<Producto> getAll() {
        return productoRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    public Collection<Producto> getAllByCategoriaName(String categoriaName) {
        return productoRepository.findAllByCategoria_Name(categoriaName)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    public Collection<Producto> getAllByCategoriaId(Long categoriaId) {
        return productoRepository.findAllByCategoria_Id(categoriaId)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Producto save(Producto producto) {
        return null;
    }

    @Override
    public Producto update(Producto producto) {
        return null;
    }

    @Override
    public void delete(Producto producto) {

    }
}
