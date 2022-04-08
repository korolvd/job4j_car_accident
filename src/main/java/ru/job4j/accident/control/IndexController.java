package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/accident")
    public String index(Model model) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add("String " + i);
        }
        model.addAttribute("list", list);
        return "index";
    }
}
