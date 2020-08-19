package cl.crisgvera.ensayodos.model;

import cl.crisgvera.ensayodos.model.relation.ProductoFacturaId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "detallefactura")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetalleFactura {
    @EmbeddedId
    private ProductoFacturaId productoFacturaId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @MapsId("productoid")
    @JoinColumn(name = "productoid", nullable = false)
    @JsonIgnore
    private Producto producto;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("facturaid")
    @JoinColumn(name = "facturaid")
    @JsonIgnore
    private Factura factura;

    @Column(name = "cantidad")
    private int quantity;
}
