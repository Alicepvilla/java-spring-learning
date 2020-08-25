package cl.crisgvera.ensayocuatro.repository;

import cl.crisgvera.ensayocuatro.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
