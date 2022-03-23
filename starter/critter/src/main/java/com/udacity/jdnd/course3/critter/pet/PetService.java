package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PetService {
    private PetRepository petRepository;
    private CustomerRepository customerRepository;

    public PetService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    public Pet savePet(Pet pet) {
        Pet savedPet = petRepository.save(pet);
        Customer owner = savedPet.getOwner();
        List<Pet> pets = owner.getPets();
        if (pets == null) {
            owner.setPets(new ArrayList<>());
        }
        owner.addPet(pet);
        customerRepository.save(owner);
        return savedPet;
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
