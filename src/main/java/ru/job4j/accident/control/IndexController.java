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
import ru.job4j.accident.service.AccidentTypeService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class IndexController {

    private final AccidentService accidentService;
    private final AccidentTypeService typeService;

    public IndexController(AccidentService service, AccidentTypeService typeService) {
        this.accidentService = service;
        this.typeService = typeService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }

    @GetMapping("/addForm")
    public String addAccident(Model model) {
        Collection<AccidentType> types = typeService.findAll();
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
        accidentService.add(accident);
        String[] ids = req.getParameterValues("rIds");
        return "redirect:/index";
    }

    @GetMapping("/editForm")
    public String editAccident(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidentService.findById(id));
        return "editForm";
    }

    @PostMapping("/updateAccident")
    public String update(@ModelAttribute Accident accident) {
        accidentService.update(accident);
        return "redirect:/index";
    }
}
