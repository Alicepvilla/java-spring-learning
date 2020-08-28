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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@Log4j2
@Controller
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping
    public String crearAgenda(@ModelAttribute("agenda") Agenda agenda,
                              Model model) {
        model = setDoctoresAndEspecialidades(model);
        boolean areCreatingAgenda = agenda.getId() == null;

        if (areCreatingAgenda) {
            if (agendaService.findByDateAndTime(agenda.getDate(), agenda.getTime()) != null) {
                log.warn("Solicitud de reserva en horario inválido");
                model.addAttribute("errorMsg", "Horario reservado");
                return "index";
            }
        }

        if (agenda.getDate() != null) {
            if (agenda.getDate().isBefore(LocalDate.now()) ||
                    (agenda.getDate().isEqual(LocalDate.now()) &&
                            agenda.getTime().isBefore(LocalTime.now()))) {
                log.warn("Solicitud de reserva en horario inválido");
                model.addAttribute("errorMsg", "Fecha u hora inválida");
                return "index";
            }
        } else {
            model.addAttribute("errorMsg", "Debes ingresar una fecha");
            return "index";
        }

        agenda = agendaService.createOrUpdate(agenda);

        if (areCreatingAgenda) {
            model.addAttribute("successfulMsg", "Reserva creada a nombre de " + agenda.getPaciente().getFullName());
            model.addAttribute("agenda", new Agenda());
        } else {
            model.addAttribute("successfulMsg", "Reserva actualizada");
            model.addAttribute("agendas", agendaService.findAll());
        }

        return "index";
    }

    @GetMapping
    public String actualizarAgenda(@RequestParam("id") String id,
                                   Model model) {
        try {
            Long agendaId = Long.valueOf(id);
            Agenda agenda = agendaService.findById(agendaId);
            if (agenda != null) model.addAttribute("agenda", agenda);
            else {
                model.addAttribute("errorMsg", "Agenda ID " + id + " no existe");
                model.addAttribute("agenda", new Agenda());
            }
            model = setDoctoresAndEspecialidades(model);
            log.info("Reserva " + id + " encontrada");
        } catch (Exception e) {
            log.warn("Agenda ID: " + id + ", no es de tipo Long - Actualizar agenda");
            model.addAttribute("agenda", new Agenda());
            model = setDoctoresAndEspecialidades(model);
            model.addAttribute("errorMsg", "Agenda ID inválido");
        }
        return "agenda/update";
    }

    @PostMapping("/eliminar")
    public String eliminarAgenda(@RequestParam("id") String id,
                                 Model model) {
        try {
            Long agendaId = Long.valueOf(id);
            agendaService.delete(agendaService.findById(agendaId));
            log.info("Reserva eliminada de la base de datos");
        } catch (Exception e) {
            log.warn("Agenda ID: " + id + ", no es de tipo Long - Eliminar agenda");
            model.addAttribute("errorMsg", "Agenda ID inválido");
            return "index";
        }
        return "redirect:/listado";
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
