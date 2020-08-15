package cl.crisgvera.repasocuatro.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Proveedor {
    @Id
    @Column(name = "rutproveedor", length = 15)
    private String rut;

    @Column(name = "nombreproveedor",length = 50)
    private String nombre;

    @Column(length = 100)
    private String direccion;

    @Column(length = 30)
    private String comuna;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();

    public Proveedor() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
        item.setProveedor(this);
    }

    public void removeItem(Item item) {
        items.remove(item);
        item.setProveedor(null);
    }
}
