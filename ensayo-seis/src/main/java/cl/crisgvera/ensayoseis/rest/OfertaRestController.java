package cl.crisgvera.ensayoseis.rest;

import cl.crisgvera.ensayoseis.model.Oferta;
import cl.crisgvera.ensayoseis.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/rest/oferta")
public class OfertaRestController {

    @Autowired
    private OfertaService ofertaService;

    @GetMapping("/get-all")
    public Collection<Oferta> getAll() {
        return ofertaService.findAll();
    }

}
