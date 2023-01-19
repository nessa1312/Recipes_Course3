package me.nessa.course3_hw2.services;

import me.nessa.course3_hw2.model.Recipe;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe obtainRecipe(int number);
}
