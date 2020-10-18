package com.example.springBoot_JPA_Assignment.repository;

import com.example.springBoot_JPA_Assignment.entities.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;


public interface RecipeIngredientRepo extends CrudRepository<RecipeIngredient, Integer> {

    RecipeIngredient create (RecipeIngredient recipeIngredient);
    RecipeIngredient findById (String recipeIngredientId);
    RecipeIngredient findByName (String recipeIngredientName);
    RecipeIngredient update (RecipeIngredient recipeIngredient);
    void delete (RecipeIngredient recipeIngredient);
}
