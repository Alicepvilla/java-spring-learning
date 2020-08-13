package cl.simulacion.sim.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Beneficiarios")
public class Beneficiario {
    @Id
    private Long beneficiarioid;

    @Column(length = 75)
    private String nombre;

    private int edad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ciudadid")
    @JsonIgnore
    private Ciudad ciudad;

    @OneToMany(mappedBy = "beneficiario")
    @JsonIgnore
    private Set<Ayuda> ayudas = new HashSet<>();

    public Beneficiario() {
    }

    public Set<Ayuda> getAyudas() {
        return ayudas;
    }

    public void setAyudas(Set<Ayuda> ayuda) {
        this.ayudas = ayuda;
    }

    public void addAyuda(Ayuda ayuda) {
        ayudas.add(ayuda);
        ayuda.setBeneficiario(this);
    }

    public Long getBeneficiarioid() {
        return beneficiarioid;
    }

    public void setBeneficiarioid(Long beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
