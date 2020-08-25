package cl.crisgvera.ensayocuatro.repository;

import cl.crisgvera.ensayocuatro.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    Optional<Agenda> findByDateAndTime(LocalDate date, LocalTime time);
}
