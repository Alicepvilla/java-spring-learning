package cl.crisgvera.ensayotres.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "alumno")
@Data
public class Student {
    @Id
    @Column(name = "idalumno")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "idcurso")
    @JsonIgnore
    private Course course;

    @Column(name = "nombre", length = 100)
    private String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", course=" + course.getName() +
                ", name='" + name + '\'' +
                '}';
    }
}
