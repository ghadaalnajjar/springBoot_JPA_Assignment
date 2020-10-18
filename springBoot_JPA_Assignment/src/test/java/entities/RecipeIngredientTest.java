package entities;

import com.example.springBoot_JPA_Assignment.entities.Ingredient;
import com.example.springBoot_JPA_Assignment.entities.Measurement;
import com.example.springBoot_JPA_Assignment.entities.Recipe;
import com.example.springBoot_JPA_Assignment.entities.RecipeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipeIngredientTest {

    RecipeIngredient testObject;

    String recipeIngredientId;
    Ingredient ingredient;
    double amount;
    Recipe recipe;

    @BeforeEach
    void setUp() {
        recipeIngredientId = "A01";
        amount = 0.01;
        ingredient = new Ingredient(1, "Spice Rub");
        recipe = new Recipe();
        testObject = new RecipeIngredient(recipeIngredientId ,ingredient , amount , Measurement.G, recipe);
    }

    @Test
    void test_Create() {
        assertEquals(recipeIngredientId, testObject.getRecipeIngredientId());
        assertEquals(ingredient, testObject.getIngredient());
        assertEquals(amount, testObject.getAmount());
        assertEquals(Measurement.G, testObject.getMeasurement());
        assertEquals(recipe, testObject.getRecipe());
    }

    @Test
    void test_Equals() {
        RecipeIngredient isEqual = new RecipeIngredient(recipeIngredientId ,ingredient , amount , Measurement.G, recipe);
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    void test_HashCode() {
        RecipeIngredient expected = new RecipeIngredient(recipeIngredientId ,ingredient , amount , Measurement.G, recipe);
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    void test_ToString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("A01"));
        assertTrue(toString.contains("0.01"));
    }
}
