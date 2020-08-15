package cl.crisgvera.repasocuatro.model;

import cl.crisgvera.repasocuatro.model.relational.DetalleFaena;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Faena {
    @Id
    @GeneratedValue
    @Column(name = "idfaena")
    private Long id;

    @Column(length = 100)
    private String titulo;

    @Column(length = 30)
    private String comuna;

    @Column(name = "fechainicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fechafin")
    private LocalDateTime fechaFin;

    @OneToMany(mappedBy = "faena", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetalleFaena> detalleFaenas = new HashSet<>();

    public Faena() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Set<DetalleFaena> getDetalleFaenas() {
        return detalleFaenas;
    }

    public void setDetalleFaenas(Set<DetalleFaena> detalleFaenas) {
        this.detalleFaenas = detalleFaenas;
    }

    public void addDetalleFaena(DetalleFaena detalleFaena) {
        detalleFaenas.add(detalleFaena);
        detalleFaena.setFaena(this);
    }

    public void removeDetalleFaena(DetalleFaena detalleFaena) {
        detalleFaenas.remove(detalleFaena);
        detalleFaena.setFaena(null);
    }
}
