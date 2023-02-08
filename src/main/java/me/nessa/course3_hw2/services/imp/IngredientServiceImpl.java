package me.nessa.course3_hw2.services.imp;

import me.nessa.course3_hw2.model.Ingredients;
import me.nessa.course3_hw2.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class IngredientServiceImpl implements IngredientService {

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

    @Override
    public void editIngredient(int id, Ingredients ingredient) {
        ingredientMap.put(id, ingredient);
    }

    @Override
    public void deleteIngredient(int id) {
        ingredientMap.remove(id);
    }
}
