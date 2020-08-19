package cl.crisgvera.ensayodos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    @GetMapping("")
    public String getAllByCategoriaId(@RequestParam("categoria-id") String categoriaId) {
        return "forward:/producto/categoria/id/" + categoriaId;
    }
}
