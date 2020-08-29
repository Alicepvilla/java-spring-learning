package cl.crisgvera.ensayoseis.controller;

import cl.crisgvera.ensayoseis.model.Postulante;
import cl.crisgvera.ensayoseis.service.OfertaService;
import cl.crisgvera.ensayoseis.service.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequestMapping("/postulante")
public class PostulanteController {

    @Autowired
    private OfertaService ofertaService;

    @Autowired
    private PostulanteService postulanteService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping
    public String index() {
        return "redirect:/postulante/registro";
    }

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("postulante", new Postulante());
        return "postulante/registro";
    }

    @GetMapping("/postular")
    public String postular(Model model) {
        // Se me olvidó hacer la llamada REST
        model.addAttribute("ofertas", ofertaService.findAll());
        model.addAttribute("postulantes", postulanteService.findAll());
        return "postulante/postular";
    }

    @PostMapping("/crear")
    public String crear(@ModelAttribute("postulante") Postulante postulante,
                        Model model) {
        if (postulanteService.findByRut(postulante.getRut()) == null){
            postulanteService.save(postulante);
            model.addAttribute("successfulMsg", "Postulante " + postulante.getFullName() + " creado");
            model.addAttribute("ofertas", ofertaService.findAll());
            model.addAttribute("postulantes", postulanteService.findAll());
        } else {
            model.addAttribute("errorMsg", "Postulante RUT " + postulante.getRut() +" ya existe");
            return "postulante/registro";
        }
        return "postulante/postular";
    }

}
