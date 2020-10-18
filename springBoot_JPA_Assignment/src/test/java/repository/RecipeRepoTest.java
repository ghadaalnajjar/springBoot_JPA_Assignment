package repository;

import com.example.springBoot_JPA_Assignment.entities.*;
import com.example.springBoot_JPA_Assignment.repository.RecipeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class RecipeRepoTest {

    @Autowired
    RecipeRepo recipeRepo;
    Recipe testObject;
    List<RecipeIngredient> recipeIngredients = new ArrayList<>();


    @BeforeEach
    public void setup() {
        recipeIngredients.add(new RecipeIngredient(new Ingredient("Spicy"), 0.01 , Measurement.G, new Recipe()));

    }

    @Test
    public void test_find_By_Name() {
        List<Recipe> findByRecipeName = recipeRepo.findByRecipeName("Spicy");
        System.out.println("findByRecipeName = " + findByRecipeName);
    }

    @Test
    public void test_find_By_All_RecipeIngredient(){
        List<RecipeIngredient> findByAllRecipeIngredient = recipeRepo.findByAllRecipeIngredient("Spicy");
        System.out.println("findByAllRecipeIngredient = " + findByAllRecipeIngredient);
    }

    @Test
    public void find_By_All_RecipeCategory() {
        List<RecipeCategory> findByAllRecipeCategory = recipeRepo.findByAllRecipeCategory("Xx");
        System.out.println("findByAllRecipeCategory = " + findByAllRecipeCategory);
    }

    @Test
    public void find_By_All_RecipeCategories() {
        List<RecipeCategory> categories = new ArrayList<>();
        List<RecipeCategory> findByAllRecipeCategories = recipeRepo.findByAllRecipeCategories(categories);
        System.out.println("findByAllRecipeCategories = " + findByAllRecipeCategories);
    }
}
