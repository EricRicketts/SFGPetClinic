package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner ownerOne = new Owner();
        ownerOne.setFirstName("Micheal");
        ownerOne.setLastName("Weston");

        ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setFirstName("Fionna");
        ownerTwo.setLastName("Glenanne");

        ownerService.save(ownerTwo);

        Vet vetOne = new Vet();
        vetOne.setFirstName("Sam");
        vetOne.setLastName("Axe");

        vetService.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setFirstName("Jesse");
        vetTwo.setLastName("Porter");

        vetService.save(vetTwo);
    }
}
