package cl.crisgvera.ensayouno.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Ayudas")
public class Ayuda {
    @Id
    @GeneratedValue
    private Long ayudaid;

    private int monto;

    @Column(length = 25)
    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "BENEFICIARIOID")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Beneficiario beneficiario;

    public Ayuda() {
    }

    @Override
    public String toString() {
        return "Ayuda{" +
                "ayudaid=" + ayudaid +
                ", monto=" + monto +
                ", motivo='" + motivo + '\'' +
                ", beneficiario=" + beneficiario.getBeneficiarioid() +
                '}';
    }
}
