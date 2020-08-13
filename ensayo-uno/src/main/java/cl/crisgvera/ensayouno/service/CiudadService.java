package cl.crisgvera.ensayouno.service;

import cl.crisgvera.ensayouno.model.Ayuda;
import cl.crisgvera.ensayouno.model.Ciudad;
import cl.crisgvera.ensayouno.repository.CiudadRepository;
import cl.crisgvera.ensayouno.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CiudadService implements DAO<Ciudad, Long> {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private AyudaService ayudaService;

    public Map<String, HashMap<String, Integer>> getCiudadDetalle() {
        Collection<Ciudad> ciudades = getAll();
        Collection<Ayuda> ayudas = ayudaService.getAll();

        Map<String, HashMap<String, Integer>> ciudadDetalle = new HashMap<>();

        ciudades.forEach(ciudad -> ciudadDetalle.put(ciudad.getNombreciudad(), new HashMap<>()));

        ciudadDetalle.entrySet().forEach(entry -> {
            ayudas.forEach(ayuda -> {
                if (ayuda.getBeneficiario().getCiudad().getNombreciudad().equals(entry.getKey())) {
                    entry.getValue().computeIfPresent(ayuda.getMotivo(), (k, v) -> v + ayuda.getMonto());
                    entry.getValue().computeIfAbsent(ayuda.getMotivo(), k -> ayuda.getMonto());
                }
            });
        });

        return ciudadDetalle;
    }

    @Override
    public Ciudad getOne(Long id) {
        return Optional.ofNullable(ciudadRepository.getOne(id))
                .orElse(null);
    }

    @Override
    public Collection<Ciudad> getAll() {
        return ciudadRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Ciudad save(Ciudad ciudad) {
        return null;
    }

    @Override
    public Ciudad update(Ciudad ciudad) {
        return null;
    }

    @Override
    public void delete(Ciudad ciudad) {

    }
}

