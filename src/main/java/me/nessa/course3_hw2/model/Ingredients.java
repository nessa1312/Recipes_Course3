package me.nessa.course3_hw2.model;

import lombok.Data;

@Data
public class Ingredients {

    private String name;
    private int countIngredient;
    private String measure;

    public Ingredients(String name, int countIngredient, String measure) {
        setName(name);
        setCountIngredient(countIngredient);
        this.measure = measure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = "Default";
        }

    }

    public int getCountIngredient() {
        return countIngredient;
    }

    public void setCountIngredient(int countIngredient) {
        if (countIngredient >= 0) {
            this.countIngredient = countIngredient;
        } else {
            this.countIngredient = -1;
        }
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        if (measure != null && !measure.isBlank()) {
            this.measure = measure;
        } else {
            this.measure = "Default";
        }
    }
}
