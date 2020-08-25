package cl.crisgvera.ensayocuatro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendas")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"paciente", "doctor"})
public class Agenda {

    @Id
    @Column(name = "idagenda")
    private Long id;

    @Column(name = "fecha")
    private LocalDate date;

    @Column(name = "horadesde")
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

}
