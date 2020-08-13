package cl.simulacion.sim.service;

import cl.simulacion.sim.model.Ayuda;
import cl.simulacion.sim.model.Ciudad;
import cl.simulacion.sim.repository.CiudadRepository;
import cl.simulacion.sim.service.util.DAO;
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

    @Override
    public Ciudad getOne(Long aLong) {
        return null;
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

    public Map<String, HashMap<String, Integer>> getCiudadAyuda() {
        Collection<Ciudad> ciudades = getAll();
        Collection<Ayuda> ayudas = ayudaService.getAll();

        Map<String, HashMap<String, Integer>> ciudadesAyudas = new HashMap<>();

        ciudades.forEach(ciudad -> ciudadesAyudas.put(ciudad.getNombreciudad(), new HashMap<>()));

        ciudadesAyudas.entrySet().forEach(entry -> {
            ayudas.forEach(ayuda -> {
                String nombreCiudad = ayuda.getBeneficiario().getCiudad().getNombreciudad();
                if (nombreCiudad.equals(entry.getKey())) {
                    entry.getValue().computeIfPresent(ayuda.getMotivo(), (k, v) -> v + ayuda.getMonto());
                    entry.getValue().computeIfAbsent(ayuda.getMotivo(), k -> ayuda.getMonto());
                }
            });
        });

        return ciudadesAyudas;
    }
}
