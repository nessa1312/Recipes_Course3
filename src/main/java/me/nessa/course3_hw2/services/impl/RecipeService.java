package me.nessa.course3_hw2.services.impl;

import org.springframework.stereotype.Service;
import  me.nessa.course3_hw2.model.Recipe;

import java.util.HashMap;
import java.util.Map;
@Service
public class RecipeService implements me.nessa.course3_hw2.services.RecipeService {

    Map<Integer, Recipe> recipeMap = new HashMap<>();

    static int counter = 0;
    @Override
    public void addRecipe(Recipe recipe) {
        recipeMap.put(counter++, recipe);
    }
    @Override
    public Recipe obtainRecipe(int number) {
        return recipeMap.get(number);
    }
}
