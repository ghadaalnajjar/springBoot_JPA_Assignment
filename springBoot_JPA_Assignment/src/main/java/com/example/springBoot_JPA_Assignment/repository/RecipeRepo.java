package com.example.springBoot_JPA_Assignment.repository;

import com.example.springBoot_JPA_Assignment.entities.Recipe;
import com.example.springBoot_JPA_Assignment.entities.RecipeCategory;
import com.example.springBoot_JPA_Assignment.entities.RecipeIngredient;
import com.example.springBoot_JPA_Assignment.entities.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepo extends CrudRepository<RecipeRepo, Integer> {

    List<Recipe> findByRecipeName (String recipeName);
    List<RecipeIngredient> findByAllRecipeIngredient (String ingredientName);
    List<RecipeCategory> findByAllRecipeCategory (String category);
    List<RecipeCategory> findByAllRecipeCategories (List<RecipeCategory> categories);
}
