package com.example.springBoot_JPA_Assignment.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe_recipe_category", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    private List<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(String category, List<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory(int categoryId, String category, List<Recipe> recipes) {
        this.categoryId = categoryId;
        this.category = category;
        this.recipes = recipes;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * Add Recipe to RecipeCategory
     * @param recipe
     */
    public void addRecipe (Recipe recipe) {
        if (recipes == null) {
            recipes = new ArrayList<>();
        }
        recipes.add(recipe);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeCategory)) return false;
        RecipeCategory that = (RecipeCategory) o;
        return categoryId == that.categoryId &&
                Objects.equals(category, that.category) &&
                Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, category, recipes);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                '}';
    }
}
