package cl.crisgvera.ensayocuatro.rest.util;

import cl.crisgvera.ensayocuatro.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorCollection {

    private Collection<Doctor> doctores;

}
