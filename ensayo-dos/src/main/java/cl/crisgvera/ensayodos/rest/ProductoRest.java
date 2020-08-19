package cl.crisgvera.ensayodos.rest;

import cl.crisgvera.ensayodos.rest.model.ProductoDto;
import cl.crisgvera.ensayodos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoRest {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/get-all")
    public ProductoDto getAll() {
        return new ProductoDto(productoService.getAll());
    }

    @GetMapping("/categoria/{categoriaName}")
    public ProductoDto getAllByCategoriaName(@PathVariable("categoriaName") String categoriaName) {
        categoriaName = StringUtils.capitalize(categoriaName.toLowerCase());
        return new ProductoDto(productoService.getAllByCategoriaName(categoriaName));
    }
}
