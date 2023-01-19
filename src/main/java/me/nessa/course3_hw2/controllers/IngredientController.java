package me.nessa.course3_hw2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.nessa.course3_hw2.model.Ingredients;
import me.nessa.course3_hw2.services.impl.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    Ingredients ingredient = new Ingredients("Яйцо", 2, "шт.");

    @GetMapping("/ingredient")
    public void add() {
        ingredientService.addIngredient(ingredient);
        ingredientService.obtainIngredient(0);
    }

}
