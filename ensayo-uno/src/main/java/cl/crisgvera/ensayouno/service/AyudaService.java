package cl.crisgvera.ensayouno.service;

import cl.crisgvera.ensayouno.model.Ayuda;
import cl.crisgvera.ensayouno.repository.AyudaRepository;
import cl.crisgvera.ensayouno.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AyudaService implements DAO<Ayuda, Long> {
    @Autowired
    private AyudaRepository ayudaRepository;

    @Override
    public Ayuda getOne(Long id) {
        return Optional.ofNullable(ayudaRepository.getOne(id))
                .orElse(null);
    }

    @Override
    public Collection<Ayuda> getAll() {
        return ayudaRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Ayuda save(Ayuda ayuda) {
        return ayudaRepository.save(ayuda);
    }

    @Override
    public Ayuda update(Ayuda ayuda) {
        return null;
    }

    @Override
    public void delete(Ayuda ayuda) {

    }
}
