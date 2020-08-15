package cl.crisgvera.repasocuatro.service.util;

import java.util.Collection;

public interface DAO<Entity, ID> {
    Entity getOne(ID id);
    Collection<Entity> getAll();
    Entity save(Entity entity);
    Entity update(Entity entity);
    void delete(Entity entity);
}
