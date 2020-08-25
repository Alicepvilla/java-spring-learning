package cl.crisgvera.ensayocuatro.service.util;

import java.util.Collection;

public interface CrudMethods<T, S> {
    T findById(S s);

    Collection<T> findAll();

    T save(T t);

    T update(T t);

    void delete(T t);
}
