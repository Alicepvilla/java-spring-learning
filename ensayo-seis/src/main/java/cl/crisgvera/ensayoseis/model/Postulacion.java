package cl.crisgvera.ensayoseis.model;

import cl.crisgvera.ensayoseis.model.relation.PostulacionId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "POSTULACIONES")
@Getter
@Setter
@NoArgsConstructor
public class Postulacion {

    @EmbeddedId
    public PostulacionId id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @MapsId(value = "IDPOSTULANTE")
    @JoinColumn(name = "IDPOSTULANTE")
    @JsonIgnore
    private Postulante postulante;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @MapsId(value = "IDOFERTA")
    @JoinColumn(name = "IDOFERTA")
    @JsonIgnore
    private Oferta oferta;
    private LocalDate fecha;

    public Postulacion(Postulante postulante, Oferta oferta) {
        id = new PostulacionId(postulante.getId(), oferta.getId());
        this.postulante = postulante;
        this.oferta = oferta;
    }

    @PrePersist
    public void prePersist(){
        fecha = LocalDate.now();
    }

}
