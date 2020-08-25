package cl.crisgvera.ensayocuatro.model;

import cl.crisgvera.ensayocuatro.model.util.DatosPersona;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctores")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "especialidad")
public class Doctor {

    @Id
    @Column(name = "iddoctor")
    private Long id;

    @Column(name = "rutdoctor", length = 11)
    private String rut;

    @Embedded
    private DatosPersona datosPersona;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Agenda> agendas = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            optional = false)
    @JoinColumn(name = "idespecialidad")
    private Especialidad especialidad;

    public void addAgenda(Agenda agenda) {
        agendas.add(agenda);
        agenda.setDoctor(this);
    }

    public void deleteAgenda(Agenda agenda) {
        agendas.remove(agenda);
        agenda.setDoctor(null);
    }

}
