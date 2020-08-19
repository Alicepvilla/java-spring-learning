package cl.crisgvera.ensayodos.repository;

import cl.crisgvera.ensayodos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Collection<Producto> findAllByCategoria_Name(String categoriaName);
}
