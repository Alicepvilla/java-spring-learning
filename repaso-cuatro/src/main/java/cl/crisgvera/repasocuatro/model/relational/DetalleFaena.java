package cl.crisgvera.repasocuatro.model.relational;

import cl.crisgvera.repasocuatro.model.Faena;
import cl.crisgvera.repasocuatro.model.Item;
import cl.crisgvera.repasocuatro.model.relational.embeddable.DetalleFaenaId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class DetalleFaena {

    @EmbeddedId
    private DetalleFaenaId id;

    @MapsId(value = "idFaena")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Item item;

    @MapsId(value = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Faena faena;

    private int cantidad;

    public DetalleFaena() {
    }

    public DetalleFaenaId getId() {
        return id;
    }

    public void setId(DetalleFaenaId id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Faena getFaena() {
        return faena;
    }

    public void setFaena(Faena faena) {
        this.faena = faena;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
