package cl.crisgvera.ensayodos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Categoria {
    @Id
    @Column(name = "categoriaid")
    private Long id;

    @Column(name = "nombre", length = 50)
    private String name;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, orphanRemoval = true)
    private Producto producto;
}
