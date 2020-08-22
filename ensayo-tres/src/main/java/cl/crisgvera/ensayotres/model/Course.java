package cl.crisgvera.ensayotres.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "curso")
@Data
@EqualsAndHashCode(exclude = "students")
public class Course {
    @Id
    @Column(name = "idcurso")
    private Long id;

    @Column(name = "nombre", length = 50)
    private String name;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    public Course() {
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourse(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setCourse(null);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students.stream().map(Student::getName) +
                '}';
    }
}
