package cl.crisgvera.ensayocinco.service;

import cl.crisgvera.ensayocinco.model.User;
import cl.crisgvera.ensayocinco.repository.UserRepository;
import cl.crisgvera.ensayocinco.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService implements CrudMethods<User, Long> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
