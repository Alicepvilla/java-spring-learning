package cl.crisgvera.ensayouno.model.rest;

import cl.crisgvera.ensayouno.model.Beneficiario;
import lombok.Data;

import java.util.Collection;

@Data
public class BeneficiarioRest {
    private Collection<Beneficiario> beneficiarios;

    public BeneficiarioRest() {
    }

    public BeneficiarioRest(Collection<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }
}
