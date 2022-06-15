package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Veterinarian;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VeterinarianService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VeterinarianServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VeterinarianService veterinarianService;

    @Autowired
    public DataLoader(OwnerService ownerService, VeterinarianService veterinarianService) {
        this.ownerService = ownerService;
        this.veterinarianService = veterinarianService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner ownerOne = new Owner();
        ownerOne.setFirstName("Micheal");
        ownerOne.setLastName("Weston");
        ownerOne.setId(1L);

        ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setFirstName("Fionna");
        ownerTwo.setLastName("Glenanne");
        ownerTwo.setId(2L);

        ownerService.save(ownerTwo);

        Veterinarian vetOne = new Veterinarian();
        vetOne.setFirstName("Sam");
        vetOne.setLastName("Axe");
        vetOne.setId(1L);

        veterinarianService.save(vetOne);

        Veterinarian vetTwo = new Veterinarian();
        vetTwo.setFirstName("Jesse");
        vetTwo.setLastName("Porter");
        vetTwo.setId(2L);

        veterinarianService.save(vetTwo);
    }
}
