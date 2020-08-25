package cl.crisgvera.ensayocuatro.service;

import cl.crisgvera.ensayocuatro.model.Agenda;
import cl.crisgvera.ensayocuatro.repository.AgendaRepository;
import cl.crisgvera.ensayocuatro.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AgendaService implements CrudMethods<Agenda, Long> {
    @Autowired
    private AgendaRepository agendaRepository;

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
}
