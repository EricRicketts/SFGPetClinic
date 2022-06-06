package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Veterinarian;

import java.util.Set;

public interface VeterinarianService {


    Veterinarian findById(Long id);

    Veterinarian save(Veterinarian veterinarian);

    Set<Veterinarian> findAll();
}
