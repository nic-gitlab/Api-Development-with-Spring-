package com.launchacademy.petTracker.controllers;

import com.launchacademy.petTracker.models.Pet;
import com.launchacademy.petTracker.respositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pets")
public class PetsRestController {

  private PetRepository petRepo;

  @Autowired
  public PetsRestController(PetRepository petRepo) {
    this.petRepo = petRepo;
  }

  @GetMapping
  public Page<Pet> getPets(Pageable pageable){
    return petRepo.findAll(pageable);
  }
}
