package me.nessa.course3_hw2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.nessa.course3_hw2.model.Recipe;
import me.nessa.course3_hw2.services.RecipeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/recipe")
@Tag(name = "Контроллер рецептов", description = "CRUD-опреции для работы с рецептами")
public class RecipeController {

    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(
            summary = "Добавление рецепта в мапу",
            description = "Необходимо передать с помощью JSON объект рецепта"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт добавлен"
            )
    })

    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.ok(recipe);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable int id, @Valid @RequestBody Recipe recipe) {
        recipeService.editRecipe(id, recipe);
        return ResponseEntity.ok().body(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().build();
    }
}
