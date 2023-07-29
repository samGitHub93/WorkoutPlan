package it.sam.workoutplan.model;

import java.util.List;

import it.sam.workoutplan.enumerator.Category;

public class StretchExercise extends Exercise {

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
