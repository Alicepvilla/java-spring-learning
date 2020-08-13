package cl.crisgvera.ensayouno.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Beneficiarios")
public class Beneficiario {

    @Id
    private Long beneficiarioid;

    @Column(length = 75)
    private String nombre;
    private int edad;

    public Beneficiario() {
    }

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "CIUDADID")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Ciudad ciudad;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Ayuda> ayudas = new HashSet<>();

    public void addAyuda(Ayuda ayuda) {
        ayudas.add(ayuda);
        ayuda.setBeneficiario(this);
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "beneficiarioid=" + beneficiarioid +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudad=" + ciudad.getNombreciudad() +
                ", ayudas=" + ayudas +
                '}';
    }
}
