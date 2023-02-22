package me.nessa.course3_hw2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;
@Data
@NoArgsConstructor
public class Recipe {

    @NotBlank
    String name;
    @Positive
    int timeCooking;
    List<Ingredients> ingredients;
    List<String> steps;
}
