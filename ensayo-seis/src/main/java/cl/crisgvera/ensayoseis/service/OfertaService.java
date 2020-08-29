package cl.crisgvera.ensayoseis.service;

import cl.crisgvera.ensayoseis.model.Oferta;
import cl.crisgvera.ensayoseis.model.Postulante;
import cl.crisgvera.ensayoseis.repository.OfertaRepository;
import cl.crisgvera.ensayoseis.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OfertaService implements CrudMethods<Oferta, Long> {
    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private ReclutadorService reclutadorService;

    @Override
    public Oferta findById(Long id) {
        return ofertaRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Collection<Oferta> findAll() {
        return ofertaRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Transactional
    @Override
    public Oferta save(Oferta oferta) {
        oferta.setReclutador(reclutadorService.findById(oferta.getReclutador().getId()));
        oferta.setId(getLastOfertaId() + 1);
        return ofertaRepository.save(oferta);
    }

    @Override
    public Oferta update(Oferta oferta) {
        return null;
    }

    @Override
    public void delete(Oferta oferta) {

    }

    public Long getLastOfertaId() {
        Oferta lastOferta = findAll().stream()
                .reduce((a1, a2) -> {
                    if (a1.getId() > a2.getId()) return a1;
                    else return a2;
                }).orElse(null);
        if (lastOferta != null) return lastOferta.getId();
        else return 0L;
    }
}
