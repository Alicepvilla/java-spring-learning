package cl.crisgvera.repasocuatro.controller;

import cl.crisgvera.repasocuatro.model.Proveedor;
import cl.crisgvera.repasocuatro.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedor/";
    }
}
