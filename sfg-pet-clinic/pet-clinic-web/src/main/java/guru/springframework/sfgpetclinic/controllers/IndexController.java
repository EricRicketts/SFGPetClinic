package guru.springframework.sfgpetclinic.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/oups")
    public String oupsHandler(Model model) {
        return "not_implemented";
    }
}

