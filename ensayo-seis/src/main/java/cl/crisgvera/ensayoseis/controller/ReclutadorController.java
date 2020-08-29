package cl.crisgvera.ensayoseis.controller;

import cl.crisgvera.ensayoseis.model.Oferta;
import cl.crisgvera.ensayoseis.model.Reclutador;
import cl.crisgvera.ensayoseis.service.OfertaService;
import cl.crisgvera.ensayoseis.service.ReclutadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequestMapping("/reclutador")
public class ReclutadorController {

    @Autowired
    private OfertaService ofertaService;

    @Autowired
    private ReclutadorService reclutadorService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping
    public String index() {
        return "redirect:/reclutador/ofertar";
    }

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("reclutador", new Reclutador());
        return "reclutador/registro";
    }

    @GetMapping("/ofertar")
    public String ofertar(Model model) {
        model.addAttribute("oferta", new Oferta());
        model.addAttribute("reclutadores", reclutadorService.findAll());
        return "reclutador/ofertar";
    }

    @GetMapping("/postulantes")
    public String postulantes(Model model) {
        // Se me olvidó hacer la llamada REST
        model.addAttribute("postulantesOfertas", ofertaService.findAll());
        return "reclutador/postulantes";
    }

    @PostMapping("/crear")
    public String crear(@ModelAttribute("reclutador") Reclutador reclutador,
                        Model model) {
        if (reclutadorService.findByRut(reclutador.getRut()) == null){
            reclutadorService.save(reclutador);
            model.addAttribute("successfulMsg", "Reclutador " + reclutador.getNombreFantasia() + " creado");
            model.addAttribute("oferta", new Oferta());
            model.addAttribute("reclutadores", reclutadorService.findAll());
        } else {
            model.addAttribute("errorMsg", "Reclutador RUT " + reclutador.getRut() +" ya existe");
            return "reclutador/registro";
        }
        return "reclutador/ofertar";
    }

}
