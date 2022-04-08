package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;

@Controller
public class IndexController {

    private final AccidentService service;

    public IndexController(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("accidents", service.findAll());
        return "index";
    }

    @GetMapping("/addForm")
    public String addAccident(Model model) {
        return "addForm";
    }

    @PostMapping("/addAccident")
    public String save(@ModelAttribute Accident accident) {
        service.add(accident);
        return "redirect:/index";
    }
}
