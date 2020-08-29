package cl.crisgvera.ensayoseis.model.relation;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostulacionId implements Serializable {

    @Column(name = "IDPOSTULANTE")
    private Long idPostulante;

    @Column(name = "IDOFERTA")
    private Long idOferta;

}
