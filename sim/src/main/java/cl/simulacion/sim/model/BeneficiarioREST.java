package cl.simulacion.sim.model;

import java.util.Collection;

public class BeneficiarioREST {
    Collection<Beneficiario> beneficiarios;

    public BeneficiarioREST() {
    }

    public BeneficiarioREST(Collection<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public Collection<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(Collection<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }
}
