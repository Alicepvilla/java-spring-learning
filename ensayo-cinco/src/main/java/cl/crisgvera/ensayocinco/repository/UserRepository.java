package cl.crisgvera.ensayocinco.repository;

import cl.crisgvera.ensayocinco.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
