package me.nessa.course3_hw2.services.impl;

import org.springframework.stereotype.Service;
import me.nessa.course3_hw2.model.Ingredients;

import java.util.HashMap;
import java.util.Map;
@Service
public class IngredientService implements me.nessa.course3_hw2.services.IngredientService {
    Map<Integer, Ingredients> ingredientMap = new HashMap<>();

    static int counter = 0;

    @Override
    public void addIngredient(Ingredients ingredient) {
        ingredientMap.put(counter++, ingredient);
    }
    @Override
    public void obtainIngredient(int number) {
        ingredientMap.get(number);
    }
}
