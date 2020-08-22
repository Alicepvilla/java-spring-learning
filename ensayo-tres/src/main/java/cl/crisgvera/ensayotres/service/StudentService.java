package cl.crisgvera.ensayotres.service;

import cl.crisgvera.ensayotres.model.Student;
import cl.crisgvera.ensayotres.service.util.DAO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService implements DAO<Student, Long> {
    @Override
    public Student getOne(Long aLong) {
        return null;
    }

    @Override
    public Collection<Student> getAll() {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public void delete(Student student) {

    }
}
