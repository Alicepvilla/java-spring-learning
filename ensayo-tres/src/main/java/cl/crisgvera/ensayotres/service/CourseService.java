package cl.crisgvera.ensayotres.service;

import cl.crisgvera.ensayotres.model.Course;
import cl.crisgvera.ensayotres.repository.CourseRepository;
import cl.crisgvera.ensayotres.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CourseService implements DAO<Course, Long> {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course getOne(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Course> getAll() {
        return courseRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public Course update(Course course) {
        return null;
    }

    @Override
    public void delete(Course course) {

    }
}
