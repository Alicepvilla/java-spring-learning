package cl.crisgvera.ensayocuatro.controller;

import cl.crisgvera.ensayocuatro.model.Agenda;
import cl.crisgvera.ensayocuatro.model.Doctor;
import cl.crisgvera.ensayocuatro.model.Especialidad;
import cl.crisgvera.ensayocuatro.rest.util.DoctorCollection;
import cl.crisgvera.ensayocuatro.rest.util.EspecialidadCollection;
import cl.crisgvera.ensayocuatro.service.AgendaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collection;

@Log4j2
@Controller
public class MainController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private AgendaService agendaService;

    @GetMapping("")
    public String index() {
        log.info("Método index");
        return "redirect:/reserva";
    }

    @GetMapping("/reserva")
    public String reservarAgenda(Model model) {
        Agenda agenda = new Agenda();
        model.addAttribute("agenda", agenda);
        log.info("Nueva agenda creada");
        model = setDoctoresAndEspecialidades(model);
        log.info("Doctores obtenidos mediante REST call");
        return "index";
    }

    @GetMapping("/listado")
    public String listarAgendas(Model model) {
        model.addAttribute("agendas", agendaService.findAll());
        log.info("Agendas obtenidas desde la base de datos");
        return "index";
    }

    private Collection<Especialidad> getEspecialidades() {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/rest/especialidad/get-all")
                .retrieve()
                .bodyToMono(EspecialidadCollection.class)
                .block()
                .getEspecialidades();
    }

    private Collection<Doctor> getDoctores() {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/rest/doctor/get-all")
                .retrieve()
                .bodyToMono(DoctorCollection.class)
                .block()
                .getDoctores();
    }

    private Model setDoctoresAndEspecialidades(Model model) {
        model.addAttribute("especialidades", getEspecialidades());
        model.addAttribute("doctores", getDoctores());
        return model;
    }

}
