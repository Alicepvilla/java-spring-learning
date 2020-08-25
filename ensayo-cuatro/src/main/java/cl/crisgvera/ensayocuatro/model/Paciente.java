package cl.crisgvera.ensayocuatro.model;

import cl.crisgvera.ensayocuatro.model.util.DatosPersona;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
public class Paciente {

    @Id
    @Column(name = "idpaciente")
    private Long id;

    @Column(name = "rutpaciente", length = 11, unique = true)
    private String rut;

    @Embedded
    private DatosPersona datosPersona;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Agenda> agendas = new HashSet<>();

    public void addAgenda(Agenda agenda) {
        agendas.add(agenda);
        agenda.setPaciente(this);
    }

    public void deleteAgenda(Agenda agenda) {
        agendas.remove(agenda);
        agenda.setPaciente(null);
    }

}
