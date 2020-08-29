package cl.crisgvera.ensayoseis.service;

import cl.crisgvera.ensayoseis.model.Reclutador;
import cl.crisgvera.ensayoseis.repository.ReclutadorRepository;
import cl.crisgvera.ensayoseis.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReclutadorService implements CrudMethods<Reclutador, Long> {
    @Autowired
    private ReclutadorRepository reclutadorRepository;

    @Override
    public Reclutador findById(Long id) {
        return reclutadorRepository.findById(id)
                .orElse(null);
    }

    public Reclutador findByRut(String rut) {
        return reclutadorRepository.findByRut(rut)
                .orElse(null);
    }

    @Override
    public Collection<Reclutador> findAll() {
        return reclutadorRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Reclutador save(Reclutador reclutador) {
        reclutador.setId(getLastReclutadorId() + 1);
        return reclutadorRepository.save(reclutador);
    }

    @Override
    public Reclutador update(Reclutador reclutador) {
        return null;
    }

    @Override
    public void delete(Reclutador reclutador) {

    }

    public Long getLastReclutadorId() {
        Reclutador lastReclutador = findAll().stream()
                .reduce((a1, a2) -> {
                    if (a1.getId() > a2.getId()) return a1;
                    else return a2;
                }).orElse(null);
        if (lastReclutador != null) return lastReclutador.getId();
        else return 0L;
    }
}
