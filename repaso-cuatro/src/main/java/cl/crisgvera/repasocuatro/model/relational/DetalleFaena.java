package cl.crisgvera.repasocuatro.model.relational;

import cl.crisgvera.repasocuatro.model.Faena;
import cl.crisgvera.repasocuatro.model.Item;
import cl.crisgvera.repasocuatro.model.relational.embeddable.DetalleFaenaId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DetalleFaena implements Serializable {

    @EmbeddedId
    private DetalleFaenaId id = new DetalleFaenaId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idFaena")
    @JoinColumn(name = "idFaena")
    @JsonIgnore
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codProducto")
    @JoinColumn(name = "codProducto")
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
        item.getDetalleFaenas().add(this);
    }

    public Faena getFaena() {
        return faena;
    }

    public void setFaena(Faena faena) {
        this.faena = faena;
        faena.getDetalleFaenas().add(this);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
