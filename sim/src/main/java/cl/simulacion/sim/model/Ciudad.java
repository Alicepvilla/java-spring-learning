package cl.simulacion.sim.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Ciudades")
public class Ciudad {
    @Id
    private Long ciudadid;

    @Column(length = 50)
    private String nombreciudad;

    @OneToMany(mappedBy = "ciudad")
    @JsonIgnore
    private Set<Beneficiario> beneficiarios;

    public Ciudad() {
    }

    public Set<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(Set<Beneficiario> beneficiario) {
        this.beneficiarios = beneficiario;
    }

    public Long getCiudadid() {
        return ciudadid;
    }

    public void setCiudadid(Long ciudadid) {
        this.ciudadid = ciudadid;
    }

    public String getNombreciudad() {
        return nombreciudad;
    }

    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
    }
}
