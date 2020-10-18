package com.example.springBoot_JPA_Assignment.repository;

import com.example.springBoot_JPA_Assignment.entities.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;


public interface RecipeInstructionRepo extends CrudRepository<RecipeInstruction, Integer> {

    RecipeInstruction create (RecipeInstruction recipeInstruction);
    RecipeInstruction findById (String instructionId);
    RecipeInstruction findByName (String instructions);
    RecipeInstruction update (RecipeInstruction recipeInstruction);
    void delete (RecipeInstruction recipeInstruction);
}
