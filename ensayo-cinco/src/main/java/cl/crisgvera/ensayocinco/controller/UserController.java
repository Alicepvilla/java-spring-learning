package cl.crisgvera.ensayocinco.controller;

import cl.crisgvera.ensayocinco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/setup")
    public String setupData() {
        return "redirect:/post/setup";
    }

}
