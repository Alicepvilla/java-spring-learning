package cl.crisgvera.ensayocuatro.rest;

import cl.crisgvera.ensayocuatro.rest.util.DoctorCollection;
import cl.crisgvera.ensayocuatro.service.DoctorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/rest/doctor")
public class DoctorRest {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/get-all")
    public DoctorCollection getAll() {
        log.info("getAll() DoctorRest");
        return new DoctorCollection(doctorService.findAll());
    }

}
