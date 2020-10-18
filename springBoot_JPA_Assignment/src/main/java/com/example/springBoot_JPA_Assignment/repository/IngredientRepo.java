package com.example.springBoot_JPA_Assignment.repository;

import com.example.springBoot_JPA_Assignment.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepo extends CrudRepository<Ingredient,Integer> {

    List<Ingredient> findByIngredientName (String IngredientName);
}
