package cl.simulacion.sim.service;

import cl.simulacion.sim.model.Beneficiario;
import cl.simulacion.sim.repository.BeneficiarioRepository;
import cl.simulacion.sim.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeneficiarioService implements DAO<Beneficiario, Long> {
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Override
    public Beneficiario getOne(Long id) {
        return Optional.ofNullable(beneficiarioRepository.getOne(id))
                .orElse(null);
    }

    @Override
    public Collection<Beneficiario> getAll() {
        return beneficiarioRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Beneficiario save(Beneficiario beneficiario) {
        return null;
    }

    @Override
    public Beneficiario update(Beneficiario beneficiario) {
        return null;
    }

    @Override
    public void delete(Beneficiario beneficiario) {

    }
}
