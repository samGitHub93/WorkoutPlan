package it.sam.workoutplan.model;

import it.sam.workoutplan.enumerator.Category;

public class StretchExercise extends Exercise {

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
