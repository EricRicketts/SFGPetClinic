package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner ownerOne = new Owner();
        ownerOne.setFirstName("Micheal");
        ownerOne.setLastName("Weston");
        ownerOne.setAddress("22152 Sherborn Land");
        ownerOne.setCity("Springfield");
        ownerOne.setTelephone("7034510235");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(ownerOne);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Roscoe");
        ownerOne.getPets().add(mikesPet);
        ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setFirstName("Fionna");
        ownerTwo.setLastName("Glenanne");
        ownerTwo.setAddress("105 Maple Hill Drive");
        ownerTwo.setCity("Cary");
        ownerTwo.setTelephone("9194495529");

        Pet fionnasPet = new Pet();
        fionnasPet.setPetType(savedCatPetType);
        fionnasPet.setOwner(ownerTwo);
        fionnasPet.setBirthDate(LocalDate.now());
        fionnasPet.setName("Just Cat");
        ownerTwo.getPets().add(fionnasPet);
        ownerService.save(ownerTwo);

        Vet vetOne = new Vet();
        vetOne.setFirstName("Sam");
        vetOne.setLastName("Axe");
        vetOne.getSpecialties().add(savedRadiology);
        vetService.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setFirstName("Jesse");
        vetTwo.setLastName("Porter");
        vetTwo.getSpecialties().add(savedSurgery);
        vetService.save(vetTwo);
    }
}
