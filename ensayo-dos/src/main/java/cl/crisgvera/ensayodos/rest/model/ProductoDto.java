package cl.crisgvera.ensayodos.rest.model;

import cl.crisgvera.ensayodos.model.Producto;
import lombok.Data;

import java.util.Collection;

@Data
public class ProductoDto {
    private Collection<Producto> productos;

    public ProductoDto(Collection<Producto> productos) {
        this.productos = productos;
    }
}
