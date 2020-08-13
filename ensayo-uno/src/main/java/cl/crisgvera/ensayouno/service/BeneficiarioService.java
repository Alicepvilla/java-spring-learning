package cl.crisgvera.ensayouno.service;

import cl.crisgvera.ensayouno.model.Beneficiario;
import cl.crisgvera.ensayouno.repository.BeneficiarioRepository;
import cl.crisgvera.ensayouno.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
