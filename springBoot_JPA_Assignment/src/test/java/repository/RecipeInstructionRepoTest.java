package repository;

import com.example.springBoot_JPA_Assignment.entities.Ingredient;
import com.example.springBoot_JPA_Assignment.entities.RecipeInstruction;
import com.example.springBoot_JPA_Assignment.repository.RecipeInstructionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class RecipeInstructionRepoTest {

    @Autowired
    RecipeInstructionRepo recipeInstructionRepo;

    RecipeInstruction testObject;

    @BeforeEach
    public void setUp() {
        testObject = new RecipeInstruction("A01","Pasta Pesto");
        RecipeInstruction saveObject = recipeInstructionRepo.save(testObject);
        }

        @Test
        public void create() {
            testObject = new RecipeInstruction("A01","Pasta Pesto");
            RecipeInstruction createObject = recipeInstructionRepo.create(testObject);
        }

        @Test
        public void test_find_By_Id(){
            RecipeInstruction findProductsById = recipeInstructionRepo.findById("A01");
            System.out.println("findProductsById = " + findProductsById);
        }

        @Test
        public void test_find_By_Name(){
            RecipeInstruction findProductsByName = recipeInstructionRepo.findByName("Pasta Pesto");
            System.out.println("findProductsByName = " + findProductsByName);
        }

    @Test
    public void test_Update(){
        testObject = new RecipeInstruction("B01","Pasta");
        RecipeInstruction update = recipeInstructionRepo.update(testObject);
        System.out.println("update = " + update);
    }

    @Test
    public void test_delete() {
        testObject = new RecipeInstruction("A01","Pasta Pesto");
        //RecipeInstruction deleteObject = recipeInstructionRepo.delete();
    }
}
