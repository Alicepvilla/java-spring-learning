package cl.crisgvera.repasocuatro.model;

import cl.crisgvera.repasocuatro.model.relational.DetalleFaena;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "codproducto")
    private Long id;

    @Column(name = "nombreproducto", length = 50)
    private String nombre;

    private int stock, precio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rutproveedor")
    @JsonIgnore
    private Proveedor proveedor;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetalleFaena> detalleFaenas = new HashSet<>();

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Set<DetalleFaena> getDetalleFaenas() {
        return detalleFaenas;
    }

    public void setDetalleFaenas(Set<DetalleFaena> detalleFaenas) {
        this.detalleFaenas = detalleFaenas;
    }

    public void addDetalleFaena(DetalleFaena detalleFaena) {
        detalleFaenas.add(detalleFaena);
        detalleFaena.setItem(this);
    }

    public void removeDetalleFaena(DetalleFaena detalleFaena) {
        detalleFaenas.remove(detalleFaena);
        detalleFaena.setItem(null);
    }
}
