package repository;

import com.example.springBoot_JPA_Assignment.entities.*;
import com.example.springBoot_JPA_Assignment.repository.RecipeIngredientRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
public class RecipeIngredientRepoTest {

    @Autowired
    RecipeIngredientRepo recipeIngredientRepo;

    RecipeIngredient testObject;

    String recipeIngredientId;
    Ingredient ingredient;
    double amount;
    Recipe recipe;

    @BeforeEach
    public void setUp() {
        recipeIngredientId = "A01";
        amount = 0.01;
        ingredient = new Ingredient(1, "Spice Rub");
        recipe = new Recipe();
        testObject = new RecipeIngredient(recipeIngredientId ,ingredient , amount , Measurement.G, recipe);
        RecipeIngredient saveObject = recipeIngredientRepo.create(testObject);
    }

    @Test
    public void create() {
        testObject = new RecipeIngredient(recipeIngredientId ,ingredient , amount , Measurement.G, recipe);
        RecipeIngredient createObject = recipeIngredientRepo.create(testObject);
    }

    @Test
    public void test_find_By_Id(){
        RecipeIngredient findById = recipeIngredientRepo.findById("A01");
        System.out.println("findById = " + findById);
    }

    @Test
    public void test_find_By_Name(){
        RecipeIngredient findByName = recipeIngredientRepo.findByName("Spice Rub");
        System.out.println("findByName = " + findByName);
    }

    @Test
    public void test_Update(){
        testObject = new RecipeIngredient(recipeIngredientId ,ingredient , amount , Measurement.KG, recipe);
        RecipeIngredient update = recipeIngredientRepo.update(testObject);
        System.out.println("update = " + update);
    }

    @Test
    public void test_delete() {
        testObject = new RecipeIngredient(recipeIngredientId ,ingredient , amount , Measurement.KG, recipe);
        recipeIngredientRepo.delete(testObject);
        System.out.println("delete = " + testObject);
    }
}
