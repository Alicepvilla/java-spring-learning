package cl.crisgvera.ensayodos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "productos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categoria {
    @Id
    @Column(name = "categoriaid")
    private Long id;

    @Column(name = "nombre", length = 50)
    private String name;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Producto> productos;
}
