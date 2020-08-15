package cl.crisgvera.repasocuatro.model.relational.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetalleFaenaId implements Serializable {

    @Column(name = "idfaena")
    private Long idFaena;

    @Column(name = "codproducto")
    private Long idProducto;

    public DetalleFaenaId() {}

    public Long getIdFaena() {
        return idFaena;
    }

    public void setIdFaena(Long idFaena) {
        this.idFaena = idFaena;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFaena, idProducto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        DetalleFaenaId that = (DetalleFaenaId) obj;
        return Objects.equals(idFaena, that.idFaena) &&
                Objects.equals(idProducto, that.idProducto);
    }


}
