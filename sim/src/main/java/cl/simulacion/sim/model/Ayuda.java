package cl.simulacion.sim.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Ayudas")
public class Ayuda {
    @Id
    @GeneratedValue
    private Long ayudaid;

    private int monto;

    @Column(length = 25)
    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiarioid")
    @JsonIgnore
    private Beneficiario beneficiario;

    public Ayuda() {
    }

    public Long getAyudaid() {
        return ayudaid;
    }

    public void setAyudaid(Long ayudaid) {
        this.ayudaid = ayudaid;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }
}
