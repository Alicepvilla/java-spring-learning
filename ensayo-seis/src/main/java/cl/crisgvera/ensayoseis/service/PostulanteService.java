package cl.crisgvera.ensayoseis.service;

import cl.crisgvera.ensayoseis.model.Postulante;
import cl.crisgvera.ensayoseis.repository.PostulanteRepository;
import cl.crisgvera.ensayoseis.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostulanteService implements CrudMethods<Postulante, Long> {
    @Autowired
    private PostulanteRepository postulanteRepository;

    @Override
    public Postulante findById(Long id) {
        return postulanteRepository.findById(id)
                .orElse(null);
    }

    public Postulante findByRut(String rut) {
        return postulanteRepository.findByRut(rut)
                .orElse(null);
    }

    @Override
    public Collection<Postulante> findAll() {
        return postulanteRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Postulante save(Postulante postulante) {
        postulante.setId(getLastPostulanteId() + 1);
        return postulanteRepository.save(postulante);
    }

    @Override
    public Postulante update(Postulante postulante) {
        return null;
    }

    @Override
    public void delete(Postulante postulante) {

    }

    public Long getLastPostulanteId() {
        Postulante lastPostulante = findAll().stream()
                .reduce((a1, a2) -> {
                    if (a1.getId() > a2.getId()) return a1;
                    else return a2;
                }).orElse(null);
        if (lastPostulante != null) return lastPostulante.getId();
        else return 0L;
    }
}
