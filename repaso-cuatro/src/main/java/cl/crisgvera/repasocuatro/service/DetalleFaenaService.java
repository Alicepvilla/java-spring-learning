package cl.crisgvera.repasocuatro.service;

import cl.crisgvera.repasocuatro.model.relational.DetalleFaena;
import cl.crisgvera.repasocuatro.model.relational.embeddable.DetalleFaenaId;
import cl.crisgvera.repasocuatro.repository.DetalleFaenaRepository;
import cl.crisgvera.repasocuatro.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetalleFaenaService implements DAO<DetalleFaena, DetalleFaenaId> {
    @Autowired
    private DetalleFaenaRepository detalleFaenaRepository;

    @Override
    public DetalleFaena getOne(DetalleFaenaId detalleFaenaId) {
        return Optional.ofNullable(detalleFaenaRepository.getOne(detalleFaenaId))
                .orElse(null);
    }

    @Override
    public Collection<DetalleFaena> getAll() {
        return detalleFaenaRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public DetalleFaena save(DetalleFaena detalleFaena) {
        return detalleFaenaRepository.save(detalleFaena);
    }

    @Override
    public DetalleFaena update(DetalleFaena detalleFaena) {
        return detalleFaenaRepository.save(detalleFaena);
    }

    @Override
    public void delete(DetalleFaena detalleFaena) {
        detalleFaenaRepository.delete(detalleFaena);
    }
}
