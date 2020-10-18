package com.example.springBoot_JPA_Assignment.dao;

import com.example.springBoot_JPA_Assignment.entities.Ingredient;

//I'm create this class InterfaceDao and Implementation from the beginning, I don't need removed and I will continue create Repository (Spring Data) for classes.
public interface IngredientDao {

    Ingredient create (Ingredient ingredient);
    Ingredient findById (int ingredientId);
    Ingredient findByName (String ingredientString);
    Ingredient update (Ingredient ingredient);
    boolean delete (Ingredient ingredient);
}
