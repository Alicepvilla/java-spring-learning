package cl.crisgvera.ensayocuatro.model.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class DatosPersona {

    @Column(length = 50)
    private String nombre, apellido;

}
