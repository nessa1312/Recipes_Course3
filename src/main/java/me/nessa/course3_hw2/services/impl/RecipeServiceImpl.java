package me.nessa.course3_hw2.services.impl;

import org.springframework.stereotype.Service;
import me.nessa.course3_hw2.model.Recipe;
import me.nessa.course3_hw2.services.RecipeService;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

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

    @Override
    public List<Recipe> obtainAllRecipe() {
        ArrayList<Recipe> temp = new ArrayList<>();
        for (Map.Entry<Integer, Recipe> pair : recipeMap.entrySet()) {
            temp.add(pair.getValue());
        }
        return temp;
    }

    @Override
    public void editRecipe(int id, Recipe newRecipe) {
        recipeMap.put(id, newRecipe);
    }

    @Override
    public void deleteRecipe(int i) {
        recipeMap.remove(i);
    }
}
