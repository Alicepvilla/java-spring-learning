package cl.crisgvera.ensayodos.controller;

import cl.crisgvera.ensayodos.model.Factura;
import cl.crisgvera.ensayodos.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/details")
    public String getDetails(@RequestParam(name = "factura-id", defaultValue = "0") Long id,
                             Model model) {
        Factura factura = facturaService.getOne(id);
        model.addAttribute("factura", factura);
        if (factura != null)
            model.addAttribute("valoresTotal", facturaService.getTotalValues(factura));
        return "index";
    }
}
