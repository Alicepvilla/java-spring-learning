package cl.simulacion.sim.controller;

import cl.simulacion.sim.model.Ayuda;
import cl.simulacion.sim.model.Beneficiario;
import cl.simulacion.sim.model.BeneficiarioREST;
import cl.simulacion.sim.service.AyudaService;
import cl.simulacion.sim.service.BeneficiarioService;
import cl.simulacion.sim.service.CiudadService;
import cl.simulacion.sim.service.dto.BeneficiarioAyudaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class IndexController {
    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private AyudaService ayudaService;

    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("agregarAyuda", new BeneficiarioAyudaDTO());
        BeneficiarioREST beneficiarios = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/beneficiario/getall")
                .retrieve()
                .bodyToMono(BeneficiarioREST.class)
                .block();

        model.addAttribute("beneficiarios", beneficiarios.getBeneficiarios());
        model.addAttribute("ciudadesAyudas", ciudadService.getCiudadAyuda());
        return "index";
    }

    @Transactional
    @PostMapping("/ayuda")
    public String agregarAyuda(@ModelAttribute("agregarAyuda") BeneficiarioAyudaDTO beneficiarioAyudaDTO) {
        Beneficiario beneficiario = beneficiarioService.getOne(beneficiarioAyudaDTO.getBeneficiarioid());
        Ayuda ayuda = beneficiarioAyudaDTO.getAyuda();
        beneficiario.addAyuda(ayuda);
        ayudaService.save(ayuda);
        return "redirect:/";
    }
}
