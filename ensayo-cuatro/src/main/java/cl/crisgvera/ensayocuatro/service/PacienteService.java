package cl.crisgvera.ensayocuatro.service;

import cl.crisgvera.ensayocuatro.model.Paciente;
import cl.crisgvera.ensayocuatro.repository.PacienteRepository;
import cl.crisgvera.ensayocuatro.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
        return null;
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
}
