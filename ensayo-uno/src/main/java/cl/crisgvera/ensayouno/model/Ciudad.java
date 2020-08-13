package cl.crisgvera.ensayouno.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Ciudades")
public class Ciudad {

    @Id
    private Long ciudadid;

    @Column(length = 50)
    private String nombreciudad;

    @OneToMany(mappedBy = "ciudad")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Beneficiario> beneficiarios;

    public Ciudad() {
    }
}
