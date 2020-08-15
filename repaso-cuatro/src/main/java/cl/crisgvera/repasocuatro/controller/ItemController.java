package cl.crisgvera.repasocuatro.controller;

import cl.crisgvera.repasocuatro.model.Item;
import cl.crisgvera.repasocuatro.service.ItemService;
import cl.crisgvera.repasocuatro.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("proveedores", proveedorService.getAll());
        return "item/index";
    }

    @GetMapping("/get-all")
    public String getAll(Model model) {
        model.addAttribute("items", itemService.getAll());
        return "item/get-all";
    }

    @Transactional
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        itemService.delete(itemService.getOne(id));
        return "redirect:/item/get-all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("item", itemService.getOne(id));
        model.addAttribute("proveedores", proveedorService.getAll());
        return "item/update";
    }

    @Transactional
    @PostMapping("/update-one")
    public String updateOne(@ModelAttribute("item") Item item) {
        itemService.update(item);
        return "redirect:/item/get-all";
    }

    @Transactional
    @PostMapping("/create")
    public String createOne(@ModelAttribute("item") Item item) {
        itemService.save(item);
        return "redirect:/item/";
    }
}
