package me.nessa.course3_hw2.services.impl;

import org.springframework.stereotype.Service;
import me.nessa.course3_hw2.model.Ingredients;

import java.util.Map;

public interface IngredientService {

    void addIngredient(Ingredients ingredient);

    void obtainIngredient(int number);

    void editIngredient(int id, Ingredients ingredient);

    void deleteIngredient(int id);
}
