package cl.crisgvera.ensayodos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "detalleFacturas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Factura {
    @Id
    @Column(name = "facturaid")
    private Long id;

    @Column(name = "cliente", length = 50)
    private String customer;

    @Column(name = "fecha", length = 50)
    private String date;

    @OneToMany(mappedBy = "factura", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<DetalleFactura> detalleFacturas = new HashSet<>();
}
