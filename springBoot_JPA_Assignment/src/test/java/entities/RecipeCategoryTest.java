package entities;

import com.example.springBoot_JPA_Assignment.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipeCategoryTest {

    RecipeCategory testObject;

    int categoryId;
    String category;
    List<Recipe> recipes = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        categoryId = 1;
        category = "Xx";
        recipes.add(new Recipe());

        testObject = new RecipeCategory(1,"Xx", recipes);
    }

    @Test
    public void test_Create() {
        assertEquals(1, testObject.getCategoryId());
        assertEquals("Xx", testObject.getCategory());
    }

    @Test
    public void test_Equals() {
        RecipeCategory isEqual = new RecipeCategory(categoryId, category, recipes);
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    public void test_HashCode() {
        RecipeCategory expected = new RecipeCategory(categoryId, category, recipes);
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    public void test_ToString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("1"));
        assertTrue(toString.contains("Xx"));
    }
}
