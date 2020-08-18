package cl.crisgvera.ensayodos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Producto {
    @Id
    @Column(name = "productoid")
    private Long id;

    @Column(name = "nombre", length = 30)
    private String name;

    @Column(name = "valor")
    private int value;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriaid", nullable = false)
    @JsonIgnore
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<DetalleFactura> detalleFactura = new HashSet<>();
}
