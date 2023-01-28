package me.nessa.course3_hw2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@NoArgsConstructor
@Data

public class Ingredients {
    @NotBlank
    private String name;
    @PositiveOrZero
    private int count;
    @NotBlank
    private String measure;

}
