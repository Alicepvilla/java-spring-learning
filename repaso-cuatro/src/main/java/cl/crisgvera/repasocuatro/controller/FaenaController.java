package cl.crisgvera.repasocuatro.controller;

import cl.crisgvera.repasocuatro.model.Faena;
import cl.crisgvera.repasocuatro.model.Item;
import cl.crisgvera.repasocuatro.model.relational.DetalleFaena;
import cl.crisgvera.repasocuatro.service.DetalleFaenaService;
import cl.crisgvera.repasocuatro.service.FaenaService;
import cl.crisgvera.repasocuatro.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faena")
public class FaenaController {
    @Autowired
    private FaenaService faenaService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private DetalleFaenaService detalleFaenaService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("ifc", new ItemFaenaCantidad());
        model.addAttribute("items", itemService.getAll());
        return "faena/index";
    }

    @Transactional
    @PostMapping("/create")
    public String createOne(@ModelAttribute("ifc") ItemFaenaCantidad ifc) {
        Faena faena = faenaService.save(ifc.getFaena());

        if (ifc.getCantidad() > 0 && ifc.getItemId() != null) {
            Item item = itemService.getOne(ifc.getItemId());
            DetalleFaena detalleFaena = new DetalleFaena();
            detalleFaena.setFaena(faena);
            detalleFaena.setItem(item);
            detalleFaena.setCantidad(ifc.getCantidad());
            detalleFaenaService.save(detalleFaena);
        }

        return "redirect:/faena/";
    }

    @GetMapping("/add-item")
    public String addItem(Model model) {
        model.addAttribute("faenas", faenaService.getAll());
        model.addAttribute("items", itemService.getAll());
        return "faena/add-item";
    }
}

class ItemFaenaCantidad {
    private Faena faena;
    private Long itemId;
    private int cantidad;

    public ItemFaenaCantidad() {
    }

    public Faena getFaena() {
        return faena;
    }

    public void setFaena(Faena faena) {
        this.faena = faena;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
