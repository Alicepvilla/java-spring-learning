package cl.crisgvera.ensayocuatro.service;

import cl.crisgvera.ensayocuatro.model.Agenda;
import cl.crisgvera.ensayocuatro.model.Doctor;
import cl.crisgvera.ensayocuatro.model.Paciente;
import cl.crisgvera.ensayocuatro.repository.AgendaRepository;
import cl.crisgvera.ensayocuatro.service.util.CrudMethods;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
@Service
public class AgendaService implements CrudMethods<Agenda, Long> {
    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PacienteService pacienteService;

    @Override
    public Agenda findById(Long id) {
        return agendaRepository.findById(id)
                .orElse(null);
    }

    public Agenda findByDateAndTime(LocalDate date, LocalTime time) {
        return agendaRepository.findByDateAndTime(date, time)
                .orElse(null);
    }

    @Override
    public Collection<Agenda> findAll() {
        return agendaRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    @Override
    public Agenda update(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    @Override
    public void delete(Agenda agenda) {
        agendaRepository.delete(agenda);
    }

    @Transactional
    public Agenda createOrUpdate(Agenda agenda) {
        // Set Doctor properly
        agenda.setDoctor(doctorService.findById(agenda.getDoctor().getId()));

        if (agenda.getId() == null) {
            // Set Paciente properly
            Paciente paciente = agenda.getPaciente();
            Paciente dbPaciente = pacienteService.findByRut(paciente.getRut());
            if (dbPaciente != null) paciente = dbPaciente;
            else paciente.setId(pacienteService.getLastPacienteId() + 10);
            agenda.setPaciente(paciente);

            // Set Agenda ID manually if it doesn't have one yet
            agenda.setId(getLastAgendaId() + 1);
            agenda = save(agenda);
        } else {
            // Update Agenda if exist
            Agenda dbAgenda = findById(agenda.getId());
            dbAgenda.setDate(agenda.getDate());
            dbAgenda.setTime(agenda.getTime());
            dbAgenda.setDoctor(agenda.getDoctor());
        }

        log.info("Solicitud de reserva sin errores");
        return agenda;
    }

    public Long getLastAgendaId() {
        Agenda lastAgenda = findAll().stream()
                .reduce((a1, a2) -> {
                    if (a1.getId() > a2.getId()) return a1;
                    else return a2;
                }).orElse(null);
        if (lastAgenda != null) return lastAgenda.getId();
        else return 0L;
    }
}
