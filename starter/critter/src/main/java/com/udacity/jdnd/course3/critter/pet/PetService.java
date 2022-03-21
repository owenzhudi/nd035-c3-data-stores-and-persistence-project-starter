package com.udacity.jdnd.course3.critter.pet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet findById(Long petId) {
        return petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException("petId is not found"));
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> findAllByOwnerId(Long ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }
}
