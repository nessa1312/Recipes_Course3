package me.nessa.course3_hw2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/add")
    public ResponseEntity<Ingredients> addIngredient(@RequestBody Ingredients ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Ingredients> editIngredient (@PathVariable int id, @RequestBody Ingredients ingredient) {
        ingredientService.editIngredient(id, ingredient);
        return ResponseEntity.ok().body(ingredient);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ingredients> deleteIngredient(@PathVariable int id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }

}
