package cl.simulacion.sim.service.dto;

import cl.simulacion.sim.model.Ayuda;

public class BeneficiarioAyudaDTO {
    private Long beneficiarioid;
    private Ayuda ayuda;

    public BeneficiarioAyudaDTO() {
    }

    public BeneficiarioAyudaDTO(Long beneficiarioid, Ayuda ayuda) {
        this.beneficiarioid = beneficiarioid;
        this.ayuda = ayuda;
    }

    public Long getBeneficiarioid() {
        return beneficiarioid;
    }

    public void setBeneficiarioid(Long beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
    }

    public Ayuda getAyuda() {
        return ayuda;
    }

    public void setAyuda(Ayuda ayuda) {
        this.ayuda = ayuda;
    }
}
