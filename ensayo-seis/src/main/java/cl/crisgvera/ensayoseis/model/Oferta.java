package cl.crisgvera.ensayoseis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OFERTAS")
@Getter
@Setter
@NoArgsConstructor
public class Oferta {

    @Id
    @Column(name = "IDOFERTA")
    private Long id;

    @Lob
    private String descripcion;

    @Column(length = 50)
    private String titulo;

    @Column(scale = 15, precision = 2)
    private double salario;
    private LocalDate fecha;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            optional = false)
    @JoinColumn(name = "IDRECLUTADOR")
    @JsonIgnore
    private Reclutador reclutador;

    @OneToMany(mappedBy = "oferta",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Postulacion> postulaciones = new HashSet<>();

    @PrePersist
    public void prePersist() {
        fecha = LocalDate.now();
    }

    public void addPostulacion(Postulacion postulacion) {
        postulaciones.add(postulacion);
        postulacion.setOferta(this);
    }

    public void deletePostulacion(Postulacion postulacion) {
        postulaciones.remove(postulacion);
        postulacion.setOferta(null);
    }

}
