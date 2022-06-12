package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VeterinarianController {

    @RequestMapping({"/veterinarians", "/veterinarians/index", "/veterinarians/index.html"})
    public String listVeterinarians() {
        return "veterinarians/index";
    }
}
