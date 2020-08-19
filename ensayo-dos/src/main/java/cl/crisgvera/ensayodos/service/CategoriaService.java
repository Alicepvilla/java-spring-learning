package cl.crisgvera.ensayodos.service;

import cl.crisgvera.ensayodos.model.Categoria;
import cl.crisgvera.ensayodos.repository.CategoriaRepository;
import cl.crisgvera.ensayodos.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements DAO<Categoria, Long> {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria getOne(Long aLong) {
        return null;
    }

    @Override
    public Collection<Categoria> getAll() {
        return categoriaRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Categoria save(Categoria categoria) {
        return null;
    }

    @Override
    public Categoria update(Categoria categoria) {
        return null;
    }

    @Override
    public void delete(Categoria categoria) {

    }
}
