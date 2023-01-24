package me.nessa.course3_hw2.services.impl;

import  me.nessa.course3_hw2.model.Recipe;

import java.util.List;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe obtainRecipe(int number);

    void deleteRecipe(int counter);

    List<Recipe> obtainAllRecipe();

    void editRecipe(int id, Recipe newRecipe);
}
