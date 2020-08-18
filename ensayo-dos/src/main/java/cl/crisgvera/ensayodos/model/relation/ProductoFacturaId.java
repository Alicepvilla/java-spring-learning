package cl.crisgvera.ensayodos.model.relation;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ProductoFacturaId implements Serializable {
    @Column(name = "productoid")
    private Long productoid;

    @Column(name = "facturaid")
    private Long facturaid;
}
