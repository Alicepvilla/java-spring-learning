package cl.crisgvera.ensayoseis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "POSTULANTES")
@Getter
@Setter
@NoArgsConstructor
public class Postulante {

    @Id
    @Column(name = "IDPOSTULANTE")
    private Long id;

    @Column(length = 50)
    private String nombre, apellido, email;

    @Column(length = 11, unique = true)
    private String rut;

    @Lob
    private String resumen;

    @OneToMany(mappedBy = "oferta",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Postulacion> postulaciones = new HashSet<>();

    public void addPostulacion(Postulacion postulacion) {
        postulaciones.add(postulacion);
        postulacion.setPostulante(this);
    }

    public void deletePostulacion(Postulacion postulacion) {
        postulaciones.remove(postulacion);
        postulacion.setPostulante(null);
    }

    public String getFullName() {
        return nombre + " " + apellido;
    }

}
