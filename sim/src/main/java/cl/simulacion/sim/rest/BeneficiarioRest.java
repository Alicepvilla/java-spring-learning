package cl.simulacion.sim.rest;

import cl.simulacion.sim.model.Beneficiario;
import cl.simulacion.sim.model.BeneficiarioREST;
import cl.simulacion.sim.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioRest {
    @Autowired
    private BeneficiarioService beneficiarioService;

    @GetMapping("/getall")
    public BeneficiarioREST getAll() {
        return new BeneficiarioREST(beneficiarioService.getAll());
    }
}
