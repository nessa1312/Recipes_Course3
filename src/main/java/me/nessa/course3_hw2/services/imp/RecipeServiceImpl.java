package me.nessa.course3_hw2.services.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import me.nessa.course3_hw2.model.Ingredients;
import me.nessa.course3_hw2.model.Recipe;
import me.nessa.course3_hw2.services.FileService;
import me.nessa.course3_hw2.services.RecipeService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


@Service
public class RecipeServiceImpl implements RecipeService {
    final private FileService fileService;
    Map<Integer, Recipe> recipeMap = new HashMap<>();
    static int counter = 0;
    @Value("${name.of.recipe.file}")
    private String recipeFileName;
    public RecipeServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }
    @Override
    public void addRecipe(Recipe recipe) {
        recipeMap.put(counter++, recipe);
        saveToRecipeFile();
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
        saveToRecipeFile();
    }
    @Override
    public void deleteRecipe(int i) {
        recipeMap.remove(i);
    }
    private void saveToRecipeFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            fileService.saveToFile(json, recipeFileName);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    private void readFromFile() {
        String json = fileService.readFile(recipeFileName);
        try {
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public Path createRecipeTxt() throws IOException {
        Path recipeTxt = fileService.createTempFile("recipeTxt");
        for (Recipe recipeFromMap : recipeMap.values()) {
            try (Writer writer = Files.newBufferedWriter(recipeTxt, StandardCharsets.UTF_8)) {
                StringBuilder ingredient = new StringBuilder();
                for (Ingredients ingredients : recipeFromMap.getIngredients()) {
                    ingredient
                            .append(ingredients.getName())
                            .append(" ").append(ingredients.getCount())
                            .append(" ").append(ingredients.getMeasure())
                            .append("\n");
                }
                StringBuilder steps = new StringBuilder();
                for (String stepsFromList : recipeFromMap.getSteps()) {
                    steps.append("\n").append(stepsFromList.replace("[", "-"));
                }
                writer
                        .append(recipeFromMap.getName())
                        .append(": время приготовления ")
                        .append(String.valueOf(recipeFromMap.getTimeCooking()))
                        .append("минут, \n")
                        .append(String.valueOf(ingredient))
                        .append(String.valueOf(steps))
                        .append("\n");
            }
        }
        return recipeTxt;
    }
}
