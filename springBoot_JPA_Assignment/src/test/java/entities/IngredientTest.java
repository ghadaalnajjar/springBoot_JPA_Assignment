package entities;

import com.example.springBoot_JPA_Assignment.entities.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IngredientTest {

    Ingredient testObject = null;

    @BeforeEach
    public void setUp() {
        testObject = new Ingredient(1, "Spice Rub");
    }

    @Test
    public void test_Create() {
        assertEquals(1, testObject.getIngredientId());
        assertEquals("Spice Rub", testObject.getIngredientName());
    }

    @Test
    public void test_Equals() {
        Ingredient isEqual = new Ingredient(1, "Spice Rub");
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    public void test_HashCode() {
        Ingredient expected = new Ingredient(1, "Spice Rub");
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    public void test_ToString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("1"));
        assertTrue(toString.contains("Spice Rub"));
    }
}
