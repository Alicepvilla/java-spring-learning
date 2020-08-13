package cl.crisgvera.ensayouno.controller;

import cl.crisgvera.ensayouno.model.rest.BeneficiarioRest;
import cl.crisgvera.ensayouno.model.Ayuda;
import cl.crisgvera.ensayouno.model.Beneficiario;
import cl.crisgvera.ensayouno.service.AyudaService;
import cl.crisgvera.ensayouno.service.BeneficiarioService;
import cl.crisgvera.ensayouno.service.CiudadService;
import cl.crisgvera.ensayouno.service.dto.BeneficiarioAyudaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class MainController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private AyudaService ayudaService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("beneficiarioDTO", new BeneficiarioAyudaDto());
        // Simulación de consumo REST desde el lado del servidor a la misma app (?)
        BeneficiarioRest beneficiarioREST = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/beneficiarios")
                .retrieve()
                .bodyToMono(BeneficiarioRest.class)
                .block();

        model.addAttribute("beneficiarios", beneficiarioREST.getBeneficiarios());
        model.addAttribute("ciudadDetalle", ciudadService.getCiudadDetalle());
        return "index";
    }

    @Transactional
    @PostMapping("/agregar-ayuda")
    public String agregarAyuda(@ModelAttribute("beneficiarioAyuda") BeneficiarioAyudaDto beneficiarioAyudaDto) {
        Beneficiario beneficiario = beneficiarioService.getOne(beneficiarioAyudaDto.getBeneficiarioid());
        Ayuda ayuda = beneficiarioAyudaDto.getAyuda();
        beneficiario.addAyuda(ayuda);
        ayudaService.save(ayuda);
        return "redirect:/";
    }
}
