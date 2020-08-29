package cl.crisgvera.ensayoseis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RECLUTADORES")
@Getter
@Setter
@NoArgsConstructor
public class Reclutador {

    @Id
    @Column(name = "IDRECLUTADOR")
    private Long id;

    @Column(name = "NOMBREFANTASIA", length = 50)
    private String nombreFantasia;

    @Column(name = "RAZONSOCIAL", length = 50)
    private String razonSocial;

    @Column(length = 50)
    private String email;

    @Column(length = 11, unique = true)
    private String rut;

    @OneToMany(mappedBy = "reclutador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Oferta> ofertas = new HashSet<>();

    public Reclutador(Long id) {
        this.id = id;
    }

    public void addOferta(Oferta oferta) {
        ofertas.add(oferta);
        oferta.setReclutador(this);
    }

    public void deleteOferta(Oferta oferta) {
        ofertas.remove(oferta);
        oferta.setReclutador(null);
    }

}
