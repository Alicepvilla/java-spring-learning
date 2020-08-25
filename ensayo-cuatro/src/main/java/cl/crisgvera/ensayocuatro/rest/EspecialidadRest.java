package cl.crisgvera.ensayocuatro.rest;

import cl.crisgvera.ensayocuatro.rest.util.EspecialidadCollection;
import cl.crisgvera.ensayocuatro.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/especialidad")
public class EspecialidadRest {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/get-all")
    public EspecialidadCollection getAll() {
        return new EspecialidadCollection(especialidadService.findAll());
    }

}
