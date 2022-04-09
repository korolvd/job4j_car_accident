package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        List<AccidentType> types = new ArrayList<>();
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
        model.addAttribute("types", types);
        List<Rule> rules = new ArrayList<>();
        rules.add(Rule.of(1, "Статья. 1"));
        rules.add(Rule.of(2, "Статья. 2"));
        rules.add(Rule.of(3, "Статья. 3"));
        model.addAttribute("rules", rules);
        return "addForm";
    }

    @PostMapping("/addAccident")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        service.add(accident);
        String[] ids = req.getParameterValues("rIds");
        return "redirect:/index";
    }

    @GetMapping("/editForm")
    public String editAccident(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", service.findById(id));
        return "editForm";
    }

    @PostMapping("/updateAccident")
    public String update(@ModelAttribute Accident accident) {
        service.update(accident);
        return "redirect:/index";
    }
}
