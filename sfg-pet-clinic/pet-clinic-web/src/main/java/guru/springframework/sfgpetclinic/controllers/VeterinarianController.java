package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/veterinarians")
@Controller
public class VeterinarianController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listVeterinarians() {
        return "veterinarians/index";
    }
}
