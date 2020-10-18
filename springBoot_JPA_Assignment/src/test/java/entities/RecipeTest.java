package entities;

import com.example.springBoot_JPA_Assignment.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipeTest {

    Recipe testObject;

    Integer recipeId;
    String recipeName;
    List<RecipeIngredient> recipeIngredients = new ArrayList<>();
    RecipeInstruction instruction;
    List<RecipeCategory> recipeCategories = new ArrayList<>();
    List<Recipe> recipes = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        recipeId = 1;
        recipeName = "Spicy";
        recipeIngredients.add(new RecipeIngredient(new Ingredient("Spicy"), 0.01 , Measurement.G, new Recipe()));
        instruction = new RecipeInstruction("A01","Pasta Pesto");
        recipeCategories.add(new RecipeCategory(1,"Xx", recipes));

        testObject = new Recipe(1, "Spicy", recipeIngredients, instruction, recipeCategories);
    }

    @Test
    public void test_Create() {
       assertEquals(recipeId, testObject.getRecipeId());
       assertEquals(recipeName, testObject.getRecipeName());
       assertEquals(recipeIngredients ,testObject.getRecipeIngredients());
       assertEquals(instruction, testObject.getInstruction());
       assertEquals(recipeCategories, testObject.getCategories());
    }

    @Test
    public void test_Equal() {
        Recipe isEqual = new Recipe(recipeId,recipeName, recipeIngredients, instruction,recipeCategories);
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    public void test_HashCode() {
        Recipe expected = new Recipe(recipeId,recipeName, recipeIngredients, instruction,recipeCategories);
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    public void test_ToString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("1"));
        assertTrue(toString.contains("Spicy"));
        assertTrue(toString.contains("Pasta Pesto"));
        assertTrue(toString.contains("Xx"));
    }
}
