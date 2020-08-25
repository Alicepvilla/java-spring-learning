package cl.crisgvera.ensayocuatro.service;

import cl.crisgvera.ensayocuatro.model.Especialidad;
import cl.crisgvera.ensayocuatro.repository.EspecialidadRepository;
import cl.crisgvera.ensayocuatro.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EspecialidadService implements CrudMethods<Especialidad, Long> {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad findById(Long aLong) {
        return null;
    }

    @Override
    public Collection<Especialidad> findAll() {
        return especialidadRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        return null;
    }

    @Override
    public Especialidad update(Especialidad especialidad) {
        return null;
    }

    @Override
    public void delete(Especialidad especialidad) {

    }
}
