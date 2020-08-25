package cl.crisgvera.ensayocuatro.controller;

import cl.crisgvera.ensayocuatro.model.Agenda;
import cl.crisgvera.ensayocuatro.model.Doctor;
import cl.crisgvera.ensayocuatro.model.Especialidad;
import cl.crisgvera.ensayocuatro.model.Paciente;
import cl.crisgvera.ensayocuatro.rest.util.DoctorCollection;
import cl.crisgvera.ensayocuatro.rest.util.EspecialidadCollection;
import cl.crisgvera.ensayocuatro.service.AgendaService;
import cl.crisgvera.ensayocuatro.service.DoctorService;
import cl.crisgvera.ensayocuatro.service.PacienteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.Valid;

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
    private PacienteService pacienteService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Transactional
    @PostMapping
    public String crearAgenda(@Valid @ModelAttribute("agenda") Agenda agenda,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            log.warn("Solicitud de reserva tiene errores");
            model.addAttribute("especialidades", getEspecialidades());
            model.addAttribute("doctores", getDoctores());
            return "index";
        }

        if (agendaService.findByDateAndTime(agenda.getDate(), agenda.getTime()) != null) {
            log.warn("Solicitud de reserva en horario inválido");
            model.addAttribute("errorMsg", "Horario reservado");
//            model.addAttribute("agenda", agenda);
            model.addAttribute("especialidades", getEspecialidades());
            model.addAttribute(getDoctores());
            return "index";
        }

        if (agenda.getDate().isBefore(LocalDate.now()) ||
                (agenda.getDate().isEqual(LocalDate.now()) &&
                        agenda.getTime().isBefore(LocalTime.now()))) {
            log.warn("Solicitud de reserva en horario inválido");
            model.addAttribute("errorMsg", "Fecha u hora inválida");
//            model.addAttribute("agenda", agenda);
            model.addAttribute("especialidades", getEspecialidades());
            model.addAttribute(getDoctores());
        }

        Paciente paciente = agenda.getPaciente();
        Doctor doctor = agenda.getDoctor();

        Paciente pacienteBD = pacienteService.findByRut(paciente.getRut());
        doctor = doctorService.findById(doctor.getId());

        if (pacienteBD != null)
            paciente = pacienteBD;

        agenda.setDoctor(doctor);
        agenda.setPaciente(paciente);
        agendaService.save(agenda);

        log.info("Solicitud de reserva sin errores");
        model.addAttribute("successfulMsg", "Reserva creada a nombre de ");
        return "index";
    }

    @GetMapping
    public String actualizarAgenda(@RequestParam("id") String id,
                                   Model model) {
        try {
            Long agendaId = Long.valueOf(id);
            model.addAttribute("agenda", agendaService.findById(agendaId));
            log.info("Reserva " + id + " encontrada");
        } catch (Exception e) {
            log.warn("Agenda ID: " + id + ", no es de tipo Long - Actualizar agenda");
            model.addAttribute("errorMsg", "Agenda ID inválido");
            return "index";
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
        return "redirect:/";
    }

    public Collection<Especialidad> getEspecialidades() {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/rest/especialidad/get-all")
                .retrieve()
                .bodyToMono(EspecialidadCollection.class)
                .block()
                .getEspecialidades();
    }

    public Collection<Doctor> getDoctores() {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/rest/doctor/get-all")
                .retrieve()
                .bodyToMono(DoctorCollection.class)
                .block()
                .getDoctores();
    }

}
