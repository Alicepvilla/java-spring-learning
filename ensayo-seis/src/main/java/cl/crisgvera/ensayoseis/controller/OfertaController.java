package cl.crisgvera.ensayoseis.controller;

import cl.crisgvera.ensayoseis.model.Oferta;
import cl.crisgvera.ensayoseis.model.Postulante;
import cl.crisgvera.ensayoseis.model.Reclutador;
import cl.crisgvera.ensayoseis.service.OfertaService;
import cl.crisgvera.ensayoseis.service.PostulacionService;
import cl.crisgvera.ensayoseis.service.PostulanteService;
import cl.crisgvera.ensayoseis.service.ReclutadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/oferta")
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @Autowired
    private PostulanteService postulanteService;

    @Autowired
    private PostulacionService postulacionService;

    @Autowired
    private ReclutadorService reclutadorService;

    @PostMapping("/crear")
    public String crear(@ModelAttribute("oferta") Oferta oferta,
                        @RequestParam("reclutador-id") Long reclutadorId,
                        Model model) {
        oferta.setReclutador(new Reclutador(reclutadorId));
        ofertaService.save(oferta);
        model.addAttribute("successfulMsg", "Oferta " + oferta.getTitulo() + " creada");
        model.addAttribute("oferta", new Oferta());
        model.addAttribute("reclutadores", reclutadorService.findAll());
        return "reclutador/ofertar";
    }

    @PostMapping("/postular")
    public String postular(@RequestParam("postulante-id") Long postulanteId,
                           @RequestParam("oferta-id") Long ofertaId,
                           Model model) {
        Postulante postulante = postulanteService.findById(postulanteId);
        Oferta oferta = ofertaService.findById(ofertaId);

        postulacionService.save(postulante, oferta);
        model.addAttribute("successfulMsg", "Postulación realizada");
        model.addAttribute("ofertas", ofertaService.findAll());
        model.addAttribute("postulantes", postulanteService.findAll());
        return "postulante/postular";
    }

}
