package cl.crisgvera.ensayocuatro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "especialidades")
@Getter
@Setter
@NoArgsConstructor
public class Especialidad {

    @Id
    @Column(name = "idespecialidad")
    private Long id;

    @Column(name = "descripcion", length = 50)
    private String description;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "especialidad")
    @JsonIgnore
    private Set<Doctor> doctores;

    public void addDoctor(Doctor doctor) {
        doctores.add(doctor);
        doctor.setEspecialidad(this);
    }

    public void deleteDoctor(Doctor doctor) {
        doctores.remove(doctor);
        doctor.setEspecialidad(null);
    }

}
