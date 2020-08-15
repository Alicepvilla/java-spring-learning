package cl.crisgvera.repasocuatro.service;

import cl.crisgvera.repasocuatro.model.Item;
import cl.crisgvera.repasocuatro.model.Proveedor;
import cl.crisgvera.repasocuatro.repository.ItemRepository;
import cl.crisgvera.repasocuatro.service.util.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService implements DAO<Item, Long> {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProveedorService proveedorService;

    @Override
    public Item getOne(Long id) {
        return Optional.ofNullable(itemRepository.getOne(id))
                .orElse(null);
    }

    @Override
    public Collection<Item> getAll() {
        return itemRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Item save(Item item) {
        Proveedor proveedor = proveedorService
                .getOne(item.getProveedor().getRut());
        proveedor.addItem(item);
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);
    }
}
