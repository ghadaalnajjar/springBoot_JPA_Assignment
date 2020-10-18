package com.example.springBoot_JPA_Assignment.dao;

import com.example.springBoot_JPA_Assignment.entities.Ingredient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


//I'm create this class InterfaceDao and Implementation from the beginning, I don't need removed and I will continue create Repository (Spring Data) for classes.
@Repository
public class IngredientDaoImp implements IngredientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ingredient create(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException();
        }
        entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient findById(int ingredientId) {
        return entityManager.find(Ingredient.class, ingredientId);
    }

    @Override
    public Ingredient findByName(String ingredientString) {
        return entityManager.find(Ingredient.class, ingredientString);
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return entityManager.merge(ingredient);
    }

    @Override
    public boolean delete(Ingredient ingredient) {
        entityManager.remove(ingredient);
        return true;
    }
}
