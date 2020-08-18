package cl.crisgvera.repasocuatro.service;

import cl.crisgvera.repasocuatro.model.Faena;
import cl.crisgvera.repasocuatro.model.Item;
import cl.crisgvera.repasocuatro.model.relational.DetalleFaena;
import cl.crisgvera.repasocuatro.repository.FaenaRepository;
import cl.crisgvera.repasocuatro.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FaenaService implements DAO<Faena, Long> {
    @Autowired
    private FaenaRepository faenaRepository;

    @Override
    public Faena getOne(Long id) {
        return Optional.ofNullable(faenaRepository.getOne(id))
                .orElse(null);
    }

    @Override
    public Collection<Faena> getAll() {
        return faenaRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Faena save(Faena faena) {
        return faenaRepository.save(faena);
    }

    @Transactional
    public Faena saveWithItem(Faena faena, Item item, int cantidad) {
        DetalleFaena detalleFaena = new DetalleFaena();
        detalleFaena.setCantidad(cantidad);
        faena.addDetalleFaena(detalleFaena);
        item.addDetalleFaena(detalleFaena);
        return faenaRepository.save(faena);
    }

    @Override
    public Faena update(Faena faena) {
        return faenaRepository.save(faena);
    }

    @Transactional
    public Faena updateWithItem(Faena faena, Item item, int cantidad) {
        return saveWithItem(faena, item, cantidad);
    }

    @Override
    public void delete(Faena faena) {

    }
}
