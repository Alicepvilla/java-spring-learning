package cl.crisgvera.ensayoseis.service;

import cl.crisgvera.ensayoseis.model.Oferta;
import cl.crisgvera.ensayoseis.model.Postulacion;
import cl.crisgvera.ensayoseis.model.Postulante;
import cl.crisgvera.ensayoseis.model.relation.PostulacionId;
import cl.crisgvera.ensayoseis.repository.PostulacionRepository;
import cl.crisgvera.ensayoseis.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostulacionService implements CrudMethods<Postulacion, PostulacionId> {
    @Autowired
    private PostulacionRepository postulacionRepository;

    @Override
    public Postulacion findById(PostulacionId postulacionId) {
        return null;
    }

    @Override
    public Collection<Postulacion> findAll() {
        return postulacionRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Postulacion save(Postulacion postulacion) {
        return postulacionRepository.save(postulacion);
    }

    @Transactional
    public Postulacion save(Postulante postulante, Oferta oferta) {
        return save(new Postulacion(postulante, oferta));
    }

    @Override
    public Postulacion update(Postulacion postulacion) {
        return null;
    }

    @Override
    public void delete(Postulacion postulacion) {

    }
}
