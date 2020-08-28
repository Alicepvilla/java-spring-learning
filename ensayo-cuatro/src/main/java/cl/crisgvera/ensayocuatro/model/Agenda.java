package cl.crisgvera.ensayocuatro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "agendas")
@Setter
@Getter
@EqualsAndHashCode(exclude = {"paciente", "doctor"})
public class Agenda {

    @Id
    @Column(name = "idagenda")
    private Long id;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "horadesde")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime time;

    @Column(name = "duracion")
    private int duration;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            optional = false)
    @JoinColumn(name = "idpaciente")
    private Paciente paciente;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            optional = false)
    @JoinColumn(name = "iddoctor")
    private Doctor doctor;

    public Agenda() {
        LocalTime truncatedLocalTime = LocalTime.now();
        truncatedLocalTime = truncatedLocalTime.truncatedTo(ChronoUnit.HOURS)
                .plusMinutes(15 * (truncatedLocalTime.getMinute() / 15) + 15);

        time = truncatedLocalTime;
        date = LocalDate.now();
    }

    @PrePersist
    public void prePersist() {
        duration = 15;
    }

}
