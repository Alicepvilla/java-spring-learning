package cl.crisgvera.ensayocuatro.service;

import cl.crisgvera.ensayocuatro.model.Doctor;
import cl.crisgvera.ensayocuatro.repository.DoctorRepository;
import cl.crisgvera.ensayocuatro.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DoctorService implements CrudMethods<Doctor, Long> {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public Collection<Doctor> findAll() {
        return doctorRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Doctor save(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor update(Doctor doctor) {
        return null;
    }

    @Override
    public void delete(Doctor doctor) {

    }

}
