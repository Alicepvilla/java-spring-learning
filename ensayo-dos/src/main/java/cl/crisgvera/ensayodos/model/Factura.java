package cl.crisgvera.ensayodos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Factura {
    @Id
    @Column(name = "facturaid")
    private Long id;

    @Column(name = "cliente", length = 50)
    private String customer;

    @Column(name = "fecha", length = 50)
    private String date;

    @OneToMany(mappedBy = "factura", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<DetalleFactura> detalleFactura = new HashSet<>();
}
