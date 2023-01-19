package me.nessa.course3_hw2.services;

import me.nessa.course3_hw2.model.Ingredients;
import me.nessa.course3_hw2.model.Recipe;

import java.util.Map;

public interface IngredientService {

    void addIngredient(Ingredients ingredient);

    void obtainIngredient(int number);
}
