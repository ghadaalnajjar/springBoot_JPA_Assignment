package com.example.springBoot_JPA_Assignment.daoTest;

import com.example.springBoot_JPA_Assignment.dao.IngredientDao;
import com.example.springBoot_JPA_Assignment.entities.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//I'm used test with Entity Data for this class Dao.. but I will create RepositoryTest (Spring Data) for all classes....
@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
public class IngredientDaoImpTest {

    @Autowired
    IngredientDao ingredientDao;

    @Autowired

    TestEntityManager entityManager;

    Ingredient testObject;

    @BeforeEach
    void setUp() {
        testObject = entityManager.persistAndFlush(new Ingredient(1, "Spice Rub"));
    }
    @Test
    public void create() {
        Ingredient newIngredient = new Ingredient(1,"Spice Rub");
        ingredientDao.create(newIngredient);
        assertEquals(newIngredient,entityManager.find(Ingredient.class, newIngredient.getIngredientId()));
    }
    @Test
    public void findById() {
        Ingredient expected = testObject;
        Ingredient actual = ingredientDao.findById(testObject.getIngredientId());
        assertEquals(expected, actual);
    }
    @Test
    public void findByName() {
        Ingredient expected = testObject;
        Ingredient actual = ingredientDao.findByName(testObject.getIngredientName());
        assertEquals(expected, actual);
    }
    @Test
    public void update() {
        Ingredient expected = new Ingredient(testObject.getIngredientId(),"Spice Pasta");
        Ingredient actual = ingredientDao.update(expected);
        assertEquals(expected, actual);
    }
    @Test
    public void delete() {
        boolean delete = false;
        delete = ingredientDao.delete(testObject);
        assertNull(entityManager.find(Ingredient.class, testObject.getIngredientId()));
        assertTrue(delete);
    }
}
