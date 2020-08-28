package cl.crisgvera.ensayocuatro.service;

import cl.crisgvera.ensayocuatro.model.Paciente;
import cl.crisgvera.ensayocuatro.repository.PacienteRepository;
import cl.crisgvera.ensayocuatro.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PacienteService implements CrudMethods<Paciente, Long> {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente findById(Long id) {
        return pacienteRepository.findById(id)
                .orElse(null);
    }

    public Paciente findByRut(String rut) {
        return pacienteRepository.findByRut(rut)
                .orElse(null);
    }

    @Override
    public Collection<Paciente> findAll() {
        return pacienteRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente update(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void delete(Paciente paciente) {

    }

    public Long getLastPacienteId() {
        Paciente lastPaciente = findAll().stream()
                .reduce((p1, p2) -> {
                    if (p1.getId() > p2.getId()) return p1;
                    else return p2;
                }).orElse(null);
        if (lastPaciente != null) return lastPaciente.getId();
        else return 0L;
    }
}
